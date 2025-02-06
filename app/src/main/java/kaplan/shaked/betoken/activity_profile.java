package kaplan.shaked.betoken;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_profile extends AppCompatActivity {

    TextView email, gender, aboutMe;
    ImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        email = findViewById(R.id.textViewProfileEmail);
        gender = findViewById(R.id.textViewProfileGender);
        aboutMe = findViewById(R.id.textViewProfileAboutMe);
        profilePicture = findViewById(R.id.imageViewProfileProfilePicture);
    }
}