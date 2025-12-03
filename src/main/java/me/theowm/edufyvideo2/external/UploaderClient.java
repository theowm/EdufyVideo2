package me.theowm.edufyvideo2.external;


import me.theowm.edufyvideo2.dtos.UploaderDTO;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Component
public class UploaderClient {

    private final RestClient restClient;
    private final String baseUrl;

    public UploaderClient(
            RestClient restClient,
            @Value("${services.uploader.url}") String baseUrl
    ) {
        this.restClient = restClient;
        this.baseUrl = baseUrl;
    }

    public UploaderDTO getUploader(UUID uploaderId) {
        return restClient.get()
                .uri(baseUrl + "/uploaders/" + uploaderId)
                .retrieve()
                .body(UploaderDTO.class);
    }
}
