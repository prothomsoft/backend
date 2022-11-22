package pl.foto99.backend.model;

import lombok.*;

@Data
@AllArgsConstructor@NoArgsConstructor
@Getter
@ToString
public class Job {
    private int userId;
    private int id;
    private String title;
    private String body;
}
