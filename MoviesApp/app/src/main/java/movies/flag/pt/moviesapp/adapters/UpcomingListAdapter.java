package movies.flag.pt.moviesapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.Upcoming;
import movies.flag.pt.moviesapp.screens.UpcomingDetailScreen;

import static movies.flag.pt.moviesapp.screens.UpcomingDetailScreen.UPCOMING_ITEM_KEY;


public class UpcomingListAdapter extends BaseAdapter {
    private ArrayList<Upcoming> list;
    private Context context;

    public UpcomingListAdapter(ArrayList<Upcoming> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Upcoming getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.upcoming_list_item, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.wrapper = view.findViewById(R.id.upcoming_wrapper);
            viewHolder.poster = view.findViewById(R.id.upcoming_list_item_img);
            viewHolder.title = view.findViewById(R.id.upcoming_list_item_title);
            viewHolder.date = view.findViewById(R.id.upcoming_list_item_date);
            viewHolder.rate = view.findViewById(R.id.upcoming_list_item_rate);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (UpcomingListAdapter.ViewHolder) view.getTag();
        }

        final Upcoming item = getItem(position);

        viewHolder.wrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpcomingDetailScreen.class);

                intent.putExtra(UPCOMING_ITEM_KEY, item);
                context.startActivity(intent);
            }
        });

        double d = item.getVoteAverage();
        float f = (float)d;

        viewHolder.title.setText(item.getTitle());
        viewHolder.date.setText(item.getReleaseDate());
        viewHolder.rate.setRating(f);

        String posterFinalPath = "https://image.tmdb.org/t/p/" + "w185" + item.getBackdropPath();
        GetPosterAsyncTask asyncTask = new GetPosterAsyncTask(viewHolder.poster);
        asyncTask.execute(posterFinalPath);

        return view;
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

        private ImageView poster2;

        public GetPosterAsyncTask(ImageView poster2) {
            this.poster2 = poster2;


        }

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
                Bitmap bm = Bitmap.createScaledBitmap(bitmap, poster2.getWidth(),  poster2.getHeight(), false);
                poster2.setImageBitmap(bm);
            }
        }
    }

    private class ViewHolder {
        ImageView poster;
        TextView title;
        TextView date;
        RatingBar rate;
        LinearLayout wrapper;
    }
}