package kaplan.shaked.betoken;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseUtil {

    private static final String TAG = "FirebaseUtil";
    private static final String USERS = "Users";

    public static Task<AuthResult> login(String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(unused -> Log.d(TAG, "Login Successful"))
                .addOnFailureListener((Exception e) -> Log.w(TAG, "Login Failed", e));
    }

    public static Task<AuthResult> signup(String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(unused -> Log.d(TAG, "Sign Up Successful"))
                .addOnFailureListener((Exception e) -> Log.w(TAG, "Sign Up Failed", e));
    }

    public static boolean isLoggedIn() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return auth.getCurrentUser() != null;
    }

    public static FirebaseUser getCurrentUser() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        return auth.getCurrentUser();
    }

    public static void firestoreAddUser(String email) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        User user = new User(email);
        db.collection(USERS).document().set(user)
                .addOnSuccessListener(unused ->
                        Log.d(TAG, "Successfully added user to firestore"))
                .addOnFailureListener((Exception e) ->
                        Log.w(TAG, "Failed to add user to firestore", e));
    }

    public static Task<QuerySnapshot> firestoreGetUser(String email) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        return db.collection(USERS).whereEqualTo("email", email).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult().getDocuments().get(0);
                        Log.d(TAG, "gotten document: " + document.getId() + " => " + document.getData());
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                    }
                });
    }

    public static void firestoreEditUser(String email, String aboutMe, int profilePicture, String gender) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        User user = new User(email);
    }
}
