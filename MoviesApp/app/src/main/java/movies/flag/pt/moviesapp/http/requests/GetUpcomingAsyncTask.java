package movies.flag.pt.moviesapp.http.requests;

import android.content.Context;

import movies.flag.pt.moviesapp.R;
import movies.flag.pt.moviesapp.http.entities.UpcomingResponse;


public class GetUpcomingAsyncTask extends ExecuteRequestAsyncTask<UpcomingResponse> {

    private static final String PATH = "/movie/upcoming";
    private static final String LANGUAGE_KEY = "language";
    private static final String PAGE_KEY = "page";
    private static final String REGION_KEY = "region";
    private int pageValue;

    public GetUpcomingAsyncTask(Context context, int pageValue) {

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
        addQueryParam(sb, REGION_KEY, "DE");
    }

    @Override
    protected Class<UpcomingResponse> getResponseEntityClass() {
        return UpcomingResponse.class;
    }

    @Override
    protected void onResponseSuccess(UpcomingResponse upcomingResponse) {

    }

    @Override
    protected void onNetworkError() {

    }
}
