package com.kzm.ssm.dao;

import com.kzm.ssm.domain.Traveller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public interface TravellerDao {
    Traveller findById(String id)throws Exception;
    List<Traveller>findAllByOrdertId(@RequestParam("orderid") String orderid)throws Exception;
}
