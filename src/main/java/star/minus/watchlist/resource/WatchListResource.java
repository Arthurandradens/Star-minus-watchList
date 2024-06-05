package star.minus.watchlist.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Resource;
import star.minus.watchlist.models.WatchList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WatchListResource {
    private Long id;
    private Attributes attributes;

    public WatchListResource(WatchList movie) {
        this.id = movie.getId();
        this.attributes = new Attributes(movie);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public static class Attributes {
        private String name;
        private String url;
        private String type;
        private Long movieId;

        public Attributes(WatchList movie) {
            this.name = movie.getName();
            this.url = movie.getUrl();
            this.type = movie.getType();
            this.movieId = movie.getMovie_id();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Long getMovieId() {
            return movieId;
        }

        public void setMovieId(Long movieId) {
            this.movieId = movieId;
        }
    }
}
