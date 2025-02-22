package kaplan.shaked.betoken;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button loginButton, goToSignUpButton;
    EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;
        loginButton = findViewById(R.id.buttonLogin);
        goToSignUpButton = findViewById(R.id.buttonGoToSignUp);
        emailEditText = findViewById(R.id.editTextLoginEmailAddress);
        passwordEditText = findViewById(R.id.editTextLoginPassword);
        // oogaBooga1!

        loginButton.setOnClickListener(this);
        goToSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.buttonLogin) {
            if (emailEditText.getText().toString().isBlank() || passwordEditText.getText().toString().isBlank()) {
                Toast.makeText(context, "email and password can't be empty", Toast.LENGTH_SHORT).show();
            }
            FirebaseUtil
                    .login(emailEditText.getText().toString(), passwordEditText.getText().toString())
                    .addOnSuccessListener(task -> {
                        Intent intent = new Intent("android.intent.action.chats");
                        startActivity(intent);
                    })
                    .addOnFailureListener(task -> {
                        return; //add something
                    });
        }
        if (id == R.id.buttonGoToSignUp) {
            Intent intent = new Intent("android.intent.action.signup");

            startActivity(intent);
        }
    }
}