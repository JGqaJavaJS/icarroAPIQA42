package dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitiesDTO {
    private List<CityDTO> cities;
}
