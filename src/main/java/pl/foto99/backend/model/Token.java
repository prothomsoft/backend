package pl.foto99.backend.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Token {
    private String corp_id;
    private String cloud_corp_id;
    private String user_id;
    private String x_app;
    private String x_ptn;
}
