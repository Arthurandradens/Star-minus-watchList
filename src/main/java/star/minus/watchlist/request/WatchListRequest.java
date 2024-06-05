package star.minus.watchlist.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import star.minus.watchlist.models.WatchList;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WatchListRequest {
        private String name;
        private String url;
        private String type;
        private Long movie_id;

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

        public Long getMovie_id() {
            return movie_id;
        }

        public void setMovie_id(Long movie_id) {
            this.movie_id = movie_id;
        }
    }

