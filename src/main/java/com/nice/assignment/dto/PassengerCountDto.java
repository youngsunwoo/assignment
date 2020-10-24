package com.nice.assignment.dto;

import com.nice.assignment.entity.PassengerCount;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class PassengerCountDto {

    private String stationName;
    private Long passengerCount;

    public static PassengerCountDto of(PassengerCount passengerCount) {
        if (passengerCount == null) {
            return null;
        }

        return  PassengerCountDto.builder()
                .stationName(passengerCount.getStationName())
                .passengerCount(passengerCount.getPassengerCount())
                .build();
    }

}
