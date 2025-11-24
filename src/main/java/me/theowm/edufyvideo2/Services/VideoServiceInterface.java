package me.theowm.edufyvideo2.Services;

import me.theowm.edufyvideo2.Entities.Video;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface VideoServiceInterface {
    List<Video> fetchAllVideos();
    Video addNewVideo(Video video);
    Video updateVideo(UUID id, Video video);
    void deleteVideo(UUID id);
    Map<String, Object> getIdAndGenresFromUrl(String url);
}
