package bg.tuvarna.sit.animalshelter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Animal {
    private UUID id;
    private String type;
    private String name;
    private String date;

    public Animal(@JsonProperty("id") UUID id,
                  @JsonProperty("type") String type,
                  @JsonProperty("name") String name,
                  @JsonProperty("date") String date) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
