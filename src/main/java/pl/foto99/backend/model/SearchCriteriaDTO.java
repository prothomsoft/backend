package pl.foto99.backend.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SearchCriteriaDTO {
    private String type;
    private String pageNumber;
    private String pageSize;
    private String sortType;
    private String sortOrder;

}
