package ba.unsa.etf.rma.vj_18565;

public class Movie {

    private String title;
    private String overview;
    private String releaseDate;
    private String homepage;
    private String genre;

    public Movie(String title, String overview, String releaseDate, String homepage, String genre) {
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.homepage = homepage;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
