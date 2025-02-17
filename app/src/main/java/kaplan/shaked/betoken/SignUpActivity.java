package kaplan.shaked.betoken;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button signUpButton, goToLoginButton;
    EditText emailEditText, passwordEditText, rePasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        context = this;
        signUpButton = findViewById(R.id.buttonSignUp);
        goToLoginButton = findViewById(R.id.buttonGoToLogin);
        emailEditText = findViewById(R.id.editTextSignUpEmailAddress);
        passwordEditText = findViewById(R.id.editTextSignUpPassword);
        rePasswordEditText = findViewById(R.id.editTextReSignUpPassword);
        // oogaBooga1!

        signUpButton.setOnClickListener(this);
        goToLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       int id = v.getId();
       boolean isPassValid =
               isPasswordValid(passwordEditText.getText().toString(), rePasswordEditText.getText().toString());
       if (id == R.id.buttonSignUp && isPassValid) {
           if (emailEditText.getText().toString().isBlank()) {
               Toast.makeText(context, "email can't be empty", Toast.LENGTH_SHORT).show();
           }
           FirebaseUtil
                   .signup(emailEditText.getText().toString(), passwordEditText.getText().toString())
                   .addOnSuccessListener(task -> {
                       FirebaseUtil.firestoreAddUser(emailEditText.getText().toString());
                       Intent intent = new Intent("android.intent.action.chats");
                       startActivity(intent);
                   })
                   .addOnFailureListener(task -> {
                       Toast.makeText(context, "Failed to sign up", Toast.LENGTH_SHORT).show();
                   });
       } else if (id == R.id.buttonSignUp && !isPassValid) {
           Toast.makeText(context, "Password needs to include lower, upper, digit, and special characters", Toast.LENGTH_LONG).show();
       }
        if (id == R.id.buttonGoToLogin) {
           Intent intent = new Intent("android.intent.action.login");
           startActivity(intent);
       }
    }

    private boolean isPasswordValid(String password, String rePassword) {
         if (!password.equals(rePassword) || password.length() < 8) {
             return false;
         }
         char[] passwordCharArray = password.toCharArray();
         boolean containsDigits = false;
         boolean containsLowercase = false;
         boolean containsUppercase = false;
         boolean containsSpecial = false;
         for (int i = 0; i < password.length(); i++) {
             containsDigits = containsDigits || Character.isDigit(passwordCharArray[i]);
             containsLowercase = containsLowercase || Character.isLowerCase(passwordCharArray[i]);
             containsUppercase = containsUppercase || Character.isUpperCase(passwordCharArray[i]);
             containsSpecial = containsSpecial || !Character.isLetterOrDigit(passwordCharArray[i]);
         }
         return containsDigits && containsLowercase && containsUppercase && containsSpecial;
    }
}