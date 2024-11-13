package test.example.ws.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Category {

    private String id;
    private String category;

    @Builder.Default
    private List<String> points = new ArrayList<>();
}
