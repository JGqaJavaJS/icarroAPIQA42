package dto;

import lombok.*;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String serialNumber;
    private String manufacture;
    private String model;
    private String year;
    private String fuel;
    private int seats;
    private String carClass;
    private double pricePerDay;
    private String about;
    private String city;
}
