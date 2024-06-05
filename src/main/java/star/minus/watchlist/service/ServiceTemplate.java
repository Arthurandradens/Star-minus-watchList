package star.minus.watchlist.service;

import org.springframework.stereotype.Service;
import star.minus.watchlist.models.WatchList;
import star.minus.watchlist.request.WatchListRequest;
import star.minus.watchlist.resource.WatchListResource;

import java.util.List;
import java.util.Map;

public interface ServiceTemplate {
    WatchList findByItemId(Long movie_id);

    Boolean deleteAllElements(List<Long> ids);

    List<WatchListResource>findAll();

    WatchList create(WatchListRequest watchListToCreate);
    Boolean findByMovieId(Long movie_id);
}
