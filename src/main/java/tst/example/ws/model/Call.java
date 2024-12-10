package tst.example.ws.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Call {
    private String id;
    private String name;
    private Location location;
    private EmotionalTone emotionalTone;
    private String text;
    @Builder.Default
    private List<Category> categories = new ArrayList<>();
    private LocalDateTime receivedDateTime;
}
