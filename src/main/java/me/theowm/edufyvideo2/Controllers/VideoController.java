package me.theowm.edufyvideo2.Controllers;

import me.theowm.edufyvideo2.Entities.Video;
import me.theowm.edufyvideo2.Repositories.VideoRepository;
import me.theowm.edufyvideo2.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/allvideos")
    public ResponseEntity<List<Video>> getAllVideos() {
        return ResponseEntity.ok(videoService.fetchAllVideos());
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/addvideo")
    public ResponseEntity<Video> addNewVideo(@RequestBody Video video) {
        return new ResponseEntity<>(videoService.addNewVideo(video), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/deletevideo/{videoId}")
    public ResponseEntity<String> deleteVideoById(@PathVariable UUID videoId){
        videoService.deleteVideo(videoId);
        return ResponseEntity.ok("Video with id " + videoId + " was deleted");
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/updatevideo/{videoId}")
    public ResponseEntity<Video> updateVideo(@PathVariable UUID videoId, @RequestBody Video video){
        return ResponseEntity.ok(videoService.updateVideo(videoId, video));
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/getidandgenrefromurl/{url}")
    public ResponseEntity<Map<String, Object>> getIdAndGenreFromUrl(@PathVariable String url) {
        return ResponseEntity.ok(videoService.getIdAndGenresFromUrl(url));
    }

}
