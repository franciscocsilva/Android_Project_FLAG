package movies.flag.pt.moviesapp.screens;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarRecord;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import movies.flag.pt.moviesapp.R;

import movies.flag.pt.moviesapp.adapters.TvListAdapter;

import movies.flag.pt.moviesapp.http.entities.Tv;
import movies.flag.pt.moviesapp.http.entities.TvResponse;

import movies.flag.pt.moviesapp.http.requests.GetPopularTvAsyncTask;

import movies.flag.pt.moviesapp.http.services.ServiceManager;
import movies.flag.pt.moviesapp.utils.DLog;

/**
 * Created by Francisco on 19/01/2018.
 */

public class TvListScreen extends Screen {

    private ListView listView;
    private final static String LIST_KEY = "LIST_KEY";
    private ArrayList<Tv> arrayList;
    private ImageButton homeBtn;
    private ImageButton backBtn;
    private TextView tvTime;
    private TextView timeDesc;
    private View footer;
    private Button more;
    private int page_value = 1;
    private TvListAdapter tvListAdapter;
    private long refreshTempo = System.currentTimeMillis();
    private NetworkChangeReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv_list_screen);
        listView = findViewById(R.id.tv_list_screen_items);
        homeBtn = findViewById(R.id.tv_list_screen_home_btn);
        backBtn = findViewById(R.id.tv_list_screen_back_btn);
        tvTime = findViewById(R.id.tv_time);
        timeDesc = findViewById(R.id.tv_time_desc);



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
                Intent intent = new Intent(v.getContext(), HomeScreen.class);
                startActivity(intent);
            }
        });

        final SwipeRefreshLayout tvSwipeRefresh = findViewById(R.id.tv_swipe_refresh);

        tvSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                tvSwipeRefresh.setRefreshing(true);
                Log.d("Swipe", "Refreshing Number");
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tvSwipeRefresh.setRefreshing(false);
                        executeRequestNowPlaying(page_value);

                        Toast.makeText(getApplicationContext(), R.string.refresh, Toast.LENGTH_SHORT).show();

                    }
                }, 3000);
            }

        });

        LayoutInflater layoutinflater = LayoutInflater.from(TvListScreen.this);
        footer = layoutinflater.inflate(R.layout.footer_view,listView,false);
        listView.addFooterView(footer);
        more = footer.findViewById(R.id.obter_mais);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                executeRequestNowPlaying(page_value = page_value+1);
            }
        });


        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        Boolean isConnect = networkInfo != null && networkInfo.isConnectedOrConnecting();
               if (isConnect){
            executeRequestNowPlaying(page_value);
        }else {
            arrayList = (ArrayList<Tv>) Tv.listAll(Tv.class);
            tvListAdapter = new TvListAdapter(arrayList, TvListScreen.this);
            listView.setAdapter(tvListAdapter);
        }

        receiver = new NetworkChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(connectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, intentFilter);

    }


    public class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
           if(netConect(context) && timeCheck(refreshTempo))
               executeRequestNowPlaying(page_value);
        }

        boolean timeCheck(long refreshTempo){

            long tempoMilis =  System.currentTimeMillis();
            long waitTime = 1000 * 6 * 50;
            if(tempoMilis - refreshTempo > waitTime){
                return true;
            }
            return false;
        }

        boolean netConect(Context context){

            ServiceManager serviceManager = new ServiceManager(context);
            if (serviceManager.isNetworkAvailable()){
                return true;
            }else {
                return false;
            }
        }
    }

    private void executeRequestNowPlaying(final int page_value) {
        @SuppressLint("StaticFieldLeak") GetPopularTvAsyncTask asyncTask = new GetPopularTvAsyncTask(this, page_value) {

            @Override
            protected void onResponseSuccess(TvResponse tvResponse) {
                DLog.d(tag, "onResponseSuccess " + tvResponse);

                long tempoMilis =  System.currentTimeMillis();

                Date moviesDate = new Date(tempoMilis);
                String tempo = SimpleDateFormat.getTimeInstance().format(moviesDate);
                tvTime.setText(tempo);

                if(arrayList == null){

                    arrayList = tvResponse.getTv();
                    tvListAdapter = new TvListAdapter(arrayList, TvListScreen.this);
                    listView.setAdapter(tvListAdapter);
                    SugarRecord.saveInTx(arrayList);

                    PreferenceManager.getDefaultSharedPreferences(context).edit().putString("saved_time", tempo).commit();
                    PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("saved_refresh", tempoMilis).commit();

                } else {

                    arrayList.addAll(tvResponse.getTv());
                    tvListAdapter.notifyDataSetChanged();
                    SugarRecord.saveInTx(arrayList);

                    PreferenceManager.getDefaultSharedPreferences(context).edit().putString("saved_time", tempo).commit();
                    PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("saved_refresh", tempoMilis).commit();
                }
            }

            @Override
            protected void onNetworkError() {
                DLog.d(tag, "onNetworkError ");
                Toast.makeText(getApplicationContext(), getString(R.string.offline), Toast.LENGTH_SHORT).show();
            }
        };
        asyncTask.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
