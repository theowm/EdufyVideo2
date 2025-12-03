package me.theowm.edufyvideo2.dtos;
import java.util.UUID;

public class UploaderDTO {

    private UUID id;
    private String name;

    public UploaderDTO() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
