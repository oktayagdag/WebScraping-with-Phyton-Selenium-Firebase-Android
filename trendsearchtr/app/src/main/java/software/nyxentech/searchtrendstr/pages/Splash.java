package software.nyxentech.searchtrendstr.pages;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import software.nyxentech.searchtrendstr.MainActivity;
import software.nyxentech.searchtrendstr.R;

public class Splash  extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2500; // 3 saniye

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
