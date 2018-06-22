package movies.flag.pt.moviesapp.http.requests;

import android.content.Context;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.MoviesResponse;



public abstract class GetNowPlayingMoviesAsyncTask extends ExecuteRequestAsyncTask<MoviesResponse> {

    private static final String PATH = "/movie/now_playing";
    private static final String LANGUAGE_KEY = "language";
    private static final String PAGE_KEY = "page";
    private int pageValue;

    public GetNowPlayingMoviesAsyncTask(Context context, int pageValue) {

        super(context);
        this.pageValue = pageValue;
        this.context = context;
    }

    @Override
    protected String getPath() {
        return PATH;
    }

    @Override
    protected void addQueryParams(StringBuilder sb) {
        addQueryParam(sb, LANGUAGE_KEY, context.getString(R.string.textLanguage));
        addQueryParam(sb, PAGE_KEY, String.valueOf(pageValue));
    }

    @Override
    protected Class<MoviesResponse> getResponseEntityClass() {
        return MoviesResponse.class;
    }

    @Override
    protected void onResponseSuccess(MoviesResponse moviesResponse) {

    }

    @Override
    protected void onNetworkError() {

    }
}
