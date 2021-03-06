package movies.flag.pt.moviesapp.screens;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.Upcoming;


public class UpcomingDetailScreen extends Screen {

    public static final String UPCOMING_ITEM_KEY = "UPCOMING_ITEM_KEY";

    private ImageButton homeBtn;
    private ImageButton backBtn;
    private TextView title;
    private RatingBar rate;
    private TextView vote;
    private TextView overview;
    private ImageView upcomingPoster;
    private Button share;
    private TextView date;
    private TextView language;
    private TextView bomiRvw;

    private String[] bomiReview;
    private static final Random bomiBot = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upcoming_detail_screen);

        homeBtn = findViewById(R.id.upcoming_detail_screen_home_btn);
        backBtn = findViewById(R.id.upcoming_detail_screen_back_btn);
        title = findViewById(R.id.upcoming_detail_screen_title);
        rate = findViewById(R.id.upcoming_detail_screen_rating);
        vote = findViewById(R.id.upcoming_detail_screen_vote);
        overview = findViewById(R.id.upcoming_detail_screen_overview);
        upcomingPoster = findViewById(R.id.upcoming_detail_screen_poster);
        share = findViewById(R.id.upcoming_share_btn);
        date = findViewById(R.id.upcoming_detail_screen_date);
        language = findViewById(R.id.upcoming_detail_screen_language);
        bomiRvw = findViewById(R.id.upcoming_detail_screen_bomi_review);

        Intent intent = getIntent();

        Upcoming item = intent.getParcelableExtra(UPCOMING_ITEM_KEY);

        double d = item.getVoteAverage();
        float f = (float)d;
        String g = Double.toString(d);

        title.setText(item.getTitle());
        rate.setRating(f);
        overview.setText(item.getOverview());
        vote.setText(g);
        date.setText(getString(R.string.release_date) + item.getReleaseDate());
        language.setText(getString(R.string.og_language) + item.getOriginalLanguage());

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), HomeScreen.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UpcomingListScreen.class);
                startActivity(intent);
            }
        });


        String posterFinalPath = "https://image.tmdb.org/t/p/" + "w185" + item.getPosterPath();
        UpcomingDetailScreen.GetPosterAsyncTask asyncTask = new GetPosterAsyncTask();
        asyncTask.execute(posterFinalPath);

        final String shareSendText = getString(R.string.share_t_1)+ item.getTitle() + getString(R.string.share_t_2) + item.getVoteAverage() + getString(R.string.share_t_3);


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, shareSendText);
                intent.setType("text/plain");
                startActivity(intent);
            }
        });

        Resources res = getResources();
        bomiReview = res.getStringArray(R.array.bomiFrases);
        String q = bomiReview[bomiBot.nextInt(bomiReview.length)];
        bomiRvw.setText(q);
    }

    private Bitmap downloadPoster(String url) {
        Bitmap bitmap = null;
        try {
            InputStream inputStream = new java.net.URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public class GetPosterAsyncTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String poster = strings[0];
            return downloadPoster(poster);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null) {
                Bitmap bm = Bitmap.createScaledBitmap(bitmap, upcomingPoster.getWidth(), upcomingPoster.getHeight(), false);
                upcomingPoster.setImageBitmap(bm);
            }
        }
    }


}
