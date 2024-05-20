package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    private String city;
    private double lat;
    private double lng;
}
