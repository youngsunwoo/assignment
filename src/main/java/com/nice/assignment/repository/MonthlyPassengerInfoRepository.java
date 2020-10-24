package com.nice.assignment.repository;

import com.nice.assignment.entity.PassengerCount;
import com.nice.assignment.entity.MonthlyMetroPassengerInfo;
import com.nice.assignment.entity.PassengerDiffrentCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonthlyPassengerInfoRepository extends JpaRepository<MonthlyMetroPassengerInfo, Long> {

    @Query("SELECT " +
            "new com.nice.assignment.entity.PassengerCount(m.stationName, sum(m.passengerCount)) " +
            "FROM " +
            "MonthlyMetroPassengerInfo m where m.year = :year group by m.stationName")
    List<PassengerCount> getYearlyCount(Long year);


    @Query( "SELECT " +
            "new com.nice.assignment.entity.PassengerDiffrentCount(m.stationName, max(m.passengerCount) , min (m.passengerCount)) " +
            "FROM " +
            "MonthlyMetroPassengerInfo m where m.year = :year  group by m.stationName")
    List<PassengerDiffrentCount> getDiffMaxAndMin(Long year);

}
