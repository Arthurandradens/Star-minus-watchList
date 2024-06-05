package star.minus.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import star.minus.watchlist.models.WatchList;

import java.util.Arrays;
import java.util.Map;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, Long> {
    @Query("SELECT CASE WHEN COUNT(wl) > 0 THEN TRUE ELSE FALSE END FROM watchlist wl WHERE wl.movie_id = :movie_id")
    boolean findByMovie_id(@Param("movie_id") Long movie_id);
}
