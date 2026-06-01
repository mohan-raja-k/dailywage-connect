package com.dailywage.dailywage_connect.service;

import com.dailywage.dailywage_connect.model.RatingModel;
import com.dailywage.dailywage_connect.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepository rr;
    public RatingModel addRating(RatingModel rm)
    {
        return rr.save(rm);
    }
    public List<RatingModel> getAllRating()
    {
        return rr.findAll();
    }
    public String deleteRating(Long id)
    {
        rr.deleteById(id);
        return "deleted";
    }
    public RatingModel updateRating(RatingModel newvalue,Long id)
    {
        RatingModel olddata=rr.findById(id).orElse(null);
        olddata.setJobId(newvalue.getJobId());
        olddata.setUserId(newvalue.getUserId());
        olddata.setRatingComment(newvalue.getRatingComment());
        olddata.setRatingDate(newvalue.getRatingDate());
        olddata.setRatingScore(newvalue.getRatingScore());
        return rr.save(olddata);
    }
    public Double getAverageRatingScore(Long id)
    {
         return rr.getAverageRatingscore(id);
    }
}
