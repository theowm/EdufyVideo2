package me.theowm.edufyvideo2.Repositories;

import me.theowm.edufyvideo2.Entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<Video, UUID> {
    Optional<Video> findByUrl(String url);
}
