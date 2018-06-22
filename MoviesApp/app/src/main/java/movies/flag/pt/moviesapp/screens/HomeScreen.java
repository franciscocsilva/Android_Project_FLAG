package movies.flag.pt.moviesapp.screens;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import movies.flag.pt.moviesapp.R;

/**
 * Created by Francisco on 17/01/2018.
 */

public class HomeScreen extends Screen{

    private final int PERMISSION_KEY = 1;

    private Button moviesBtn;
    private Button tvBtn;
    private Button upcomingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        moviesBtn = findViewById(R.id.home_screen_movies_btn);
        tvBtn = findViewById(R.id.home_screen_tv_btn);
        upcomingBtn = findViewById(R.id.home_screen_upcoming_btn);


        moviesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MovieListScreen.class);
                startActivity(intent);
            }
        });

        tvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TvListScreen.class);
                startActivity(intent);
            }
        });

        upcomingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UpcomingListScreen.class);
                startActivity(intent);
            }
        });




        int result = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if(result == PackageManager.PERMISSION_GRANTED){

        }
        else{
            String[] permissions = new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this, permissions, PERMISSION_KEY);
        }

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_KEY){
            if(grantResults.length > 0 ){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission OK", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}