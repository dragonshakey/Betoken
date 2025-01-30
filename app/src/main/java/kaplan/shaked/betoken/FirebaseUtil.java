package kaplan.shaked.betoken;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseUtil {

    private static final String TAG = "FirebaseUtil";

    public static Task<AuthResult> login(String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Login Successful");
                    } else {
                        Log.w(TAG, "Login Failed", task.getException());
                    }
                });
    }

    public static Task<AuthResult> signup(String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Sign Up Successful");
                    } else {
                        Log.w(TAG, "Sign Up Failed", task.getException());
                    }
                });
    }

    public static boolean isLoggedIn() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return auth.getCurrentUser() != null;
    }

    public static FirebaseUser getCurrentUser() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return auth.getCurrentUser();
    }
}
