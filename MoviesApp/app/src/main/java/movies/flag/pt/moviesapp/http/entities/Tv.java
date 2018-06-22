package movies.flag.pt.moviesapp.http.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

public class Tv extends SugarRecord implements Parcelable {

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("original_Name")
    private String originalName;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("name")
    private String name;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("popularity")
    private Double popularity;

    @SerializedName("vote_count")
    private Integer voteCount;

    @SerializedName("vote_average")
    private Double voteAverage;

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getName() {
        return name;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Tv() {

    }

    protected Tv(Parcel in) {
        posterPath = in.readString();
        overview = in.readString();
        firstAirDate = in.readString();
        originalName = in.readString();
        originalLanguage = in.readString();
        name = in.readString();
        backdropPath = in.readString();
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
        voteCount = in.readByte() == 0x00 ? null : in.readInt();
        voteAverage = in.readByte() == 0x00 ? null : in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(posterPath);
        dest.writeString(overview);
        dest.writeString(firstAirDate);
        dest.writeString(originalName);
        dest.writeString(originalLanguage);
        dest.writeString(name);
        dest.writeString(backdropPath);
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(popularity);
        }
        if (voteCount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(voteCount);
        }
        if (voteAverage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(voteAverage);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Tv> CREATOR = new Parcelable.Creator<Tv>() {
        @Override
        public Tv createFromParcel(Parcel in) {
            return new Tv(in);
        }

        @Override
        public Tv[] newArray(int size) {
            return new Tv[size];
        }
    };
}
