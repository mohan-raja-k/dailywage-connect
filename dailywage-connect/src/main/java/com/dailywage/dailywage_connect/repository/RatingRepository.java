package com.dailywage.dailywage_connect.repository;

import com.dailywage.dailywage_connect.model.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RatingRepository extends JpaRepository<RatingModel,Long> {
    @Query("select AVG(r.ratingScore) from RatingModel r where r.userId= :userId ")
    Double getAverageRatingscore(Long userId);
}
