package com.dailywage.dailywage_connect.controller;

import com.dailywage.dailywage_connect.model.RatingModel;
import com.dailywage.dailywage_connect.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rating")
public class RatingController {
    @Autowired
    RatingService rs;
    @PostMapping("/addRating")
    public RatingModel addRating(@RequestBody RatingModel rm)
    {
        return rs.addRating(rm);
    }
    @GetMapping("/getRating")
    public List<RatingModel> getAllRating()
    {
        return rs.getAllRating();
    }
    @DeleteMapping("/deleteRating/{id}")
    public String deleteRating(@PathVariable Long id)
    {
        return rs.deleteRating(id);
    }
    @PutMapping("/updateRating/{id}")
    public RatingModel updateRating(@RequestBody RatingModel rm,@PathVariable Long id)
    {
        return rs.updateRating(rm,id);
    }
    @GetMapping("/getAverageRatingScore")
    public Double getAverageRatingScore(@RequestParam("userid") Long id)
    {
        return rs.getAverageRatingScore(id);
    }
}
