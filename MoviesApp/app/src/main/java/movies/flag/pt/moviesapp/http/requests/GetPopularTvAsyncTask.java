package movies.flag.pt.moviesapp.http.requests;

import android.content.Context;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.TvResponse;



public class GetPopularTvAsyncTask extends ExecuteRequestAsyncTask<TvResponse>{

    private static final String PATH = "/tv/popular";
    private static final String LANGUAGE_KEY = "language";
    private static final String PAGE_KEY = "page";
    private int pageValue;

    public GetPopularTvAsyncTask(Context context, int pageValue) {

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
    protected Class<TvResponse> getResponseEntityClass() {
        return TvResponse.class;
    }

    @Override
    protected void onResponseSuccess(TvResponse tvResponse) {

    }

    @Override
    protected void onNetworkError() {

    }


}
