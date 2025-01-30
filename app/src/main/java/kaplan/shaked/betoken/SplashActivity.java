package kaplan.shaked.betoken;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    Context context;
    ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        context = this;
        splashImage = findViewById(R.id.imageViewSplash);

        Animation splashAnimation = AnimationUtils.loadAnimation(context, R.anim.splash_animation);
        splashImage.startAnimation(splashAnimation);

        MediaPlayer player = MediaPlayer.create(context, R.raw.spash_screen_sound);
        player.start();

        new Handler().postDelayed(() -> {
            player.stop();
            Intent intent = new Intent("android.intent.action.login");
            startActivity(intent);
        }, 2000);
    }
}