package star.minus.watchlist.controllers;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import star.minus.watchlist.request.WatchListRequest;
import star.minus.watchlist.resource.WatchListResource;
import star.minus.watchlist.service.ServiceTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class WatchListController {
    private ServiceTemplate service;

    public WatchListController(ServiceTemplate service) {
        this.service = service;
    }

    @GetMapping("/watchlist")
    @CrossOrigin(origins = "https://star-minus.vercel.app")
    public ResponseEntity<Map<String, List<WatchListResource>>>index(){
        List<WatchListResource> watchList = service.findAll();
        Map<String, List<WatchListResource>> response = new HashMap<>();
        response.put("results", watchList);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Map<String,String>>store(@RequestBody WatchListRequest request){
        Map<String, String> response = new HashMap<>();
        try {
            service.create(request);
            response.put("message", "added to your list");
            response.put("type","success");
            return ResponseEntity.ok(response);
        }catch (Exception ex){
            response.put("message", "bad request");
           return ResponseEntity.ok(response);
        }
    }
    @GetMapping("/movie-status/{movie_id}")
    public Map<String,String>show(@PathVariable Long movie_id){
        Boolean status = service.findByMovieId(movie_id);
        Map<String, String> response = new HashMap<>();
        if (status){
            response.put("status","mdi-check");
        } else {
            response.put("status","mdi-plus");
        }
        return response;
    }
    @DeleteMapping("/destroy/{ids}")
    public Map<String,String>delete(@PathVariable List<Long> ids){
        Map<String,String> response = new HashMap<>();
        Boolean status = service.deleteAllElements(ids);
        if (status){
            response.put("message","Removed from your list.");
                response.put("type","warning");
                return response;
        } else {
            response.put("message", "erro");
            return response;
        }
//        try{
//                service.deleteAllElements(ids);
//                response.put("message","Removed from your list.");
//                response.put("type","warning");
//                return response;
//        } catch (HttpClientErrorException.NotFound ex) {
//            response.put("message","movie not found");
//            return response;
//        } catch (Throwable throwable){
//            response.put("message","Error in delete.");
//            response.put("error", throwable.getMessage());
//            return response;
//
//        }
    }

}
