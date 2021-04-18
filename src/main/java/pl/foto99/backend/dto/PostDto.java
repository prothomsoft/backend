package pl.foto99.backend.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDto {
    private final long id;
    private final String title;
    private final String content;
    private final LocalDateTime created;
}