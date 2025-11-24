package me.theowm.edufyvideo2.Services;

import me.theowm.edufyvideo2.Entities.Video;
import me.theowm.edufyvideo2.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.theowm.edufyvideo2.Entities.Genre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class VideoService implements VideoServiceInterface {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }


    @Override
    public List<Video> fetchAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public Video addNewVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video updateVideo(UUID id, Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void deleteVideo(UUID id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Map<String, Object> getIdAndGenresFromUrl(String url) {
        Video video = videoRepository.findByUrl(url)
                .orElseThrow(() -> new RuntimeException("Video not found with URL: " + url));

        Map<String, Object> response = new HashMap<>();
        response.put("id", video.getUuid());
        response.put("genres", video.getGenres()
                .stream()
                .map(Genre::getName)
                .toList()
        );

        return response;
    }

}
