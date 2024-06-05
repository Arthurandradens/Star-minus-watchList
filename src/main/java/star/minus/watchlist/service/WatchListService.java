package star.minus.watchlist.service;

import org.springframework.stereotype.Service;
import star.minus.watchlist.models.WatchList;
import star.minus.watchlist.repository.WatchListRepository;
import star.minus.watchlist.request.WatchListRequest;
import star.minus.watchlist.resource.WatchListResource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class WatchListService implements ServiceTemplate{
    private final WatchListRepository repository;

    public WatchListService(WatchListRepository repository) {
        this.repository = repository;
    }

    @Override
    public WatchList findByItemId(Long movie_id) {
        return null;
    }

    @Override
    public Boolean deleteAllElements(List<Long> ids) {
        if (!ids.isEmpty()) {
            for (Long id : ids) {
                repository.deleteById(id);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<WatchListResource> findAll() {
        List<WatchList> lists = repository.findAll();
        return lists.stream()
                                    .map(WatchListResource::new)
                                    .toList();

    }

    @Override
    public WatchList create(WatchListRequest request) {
        WatchList watchList = new WatchList();
        watchList.setName(request.getName());
        watchList.setType(request.getType());
        watchList.setUrl(request.getUrl());
        watchList.setMovie_id(request.getMovie_id());
        return repository.save(watchList);
    }

    public Boolean findByMovieId(Long movie_id) {
        return repository.findByMovie_id(movie_id);
    }
}
