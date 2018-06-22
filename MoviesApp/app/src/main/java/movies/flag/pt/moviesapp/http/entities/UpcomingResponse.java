package movies.flag.pt.moviesapp.http.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class UpcomingResponse {

    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private ArrayList<Upcoming> upcoming = new ArrayList<>();

    @SerializedName("total_pages")
    private Integer totalPages;

    public Integer getPage() {
        return page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public ArrayList<Upcoming> getUpcoming() {
        return upcoming;
    }
}
