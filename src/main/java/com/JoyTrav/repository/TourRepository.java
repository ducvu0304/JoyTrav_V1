package com.JoyTrav.repository;

import com.JoyTrav.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tourRepository")
public interface TourRepository extends JpaRepository<Tour, String> {
    @Query(value = "SELECT * FROM tour t LIMIT ?1 OFFSET ?2" , nativeQuery = true)
    List<Tour> findTourPage(Integer pageSize,  Integer offset);
}
