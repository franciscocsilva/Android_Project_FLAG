
package movies.flag.pt.moviesapp.http.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TvResponse {

    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private ArrayList<Tv> tv = new ArrayList<>();

    @SerializedName("total_pages")
    private Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public ArrayList<Tv> getTv() {
        return tv;
    }
}

