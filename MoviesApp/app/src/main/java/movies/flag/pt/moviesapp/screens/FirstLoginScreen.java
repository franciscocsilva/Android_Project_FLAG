package movies.flag.pt.moviesapp.screens;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import movies.flag.pt.moviesapp.R;


/**
 * Created by Francisco on 31/01/2018.
 */

public class FirstLoginScreen extends Screen {

    private final String PREFERENCES_NAME = "Preferences";
    private final String FIRST_LOGIN_KEY = "FIRST_LOGIN_KEY";

    private TextView welcome;
    private TextView title;
    private ImageView image;
    private TextView description;
    private Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_login_screen);

        welcome = findViewById(R.id.first_login_screen_welcome);
        title = findViewById(R.id.first_login_screen_title);
        image = findViewById(R.id.first_login_screen_image);
        description = findViewById(R.id.first_login_screen_desc);
        continueBtn = findViewById(R.id.first_login_screen_continueBtn);

    SharedPreferences preferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();

    boolean isFirstLogin = preferences.getBoolean(FIRST_LOGIN_KEY, true);
    if (isFirstLogin) {
        editor.putBoolean(FIRST_LOGIN_KEY, false);
        editor.commit();

    } else {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }


    Log.d("Preferences", "isFirstLogin=" + isFirstLogin);

    continueBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), HomeScreen.class);
            startActivity(intent);
        }
    });

    }
}
