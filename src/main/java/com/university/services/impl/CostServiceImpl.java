package com.university.services.impl;


import com.university.domain.Cost;
import com.university.repositories.CostRepository;
import com.university.services.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CostServiceImpl implements CostService {

    final private CostRepository costRepository;

    @Autowired
    public CostServiceImpl(CostRepository costRepository) {
        this.costRepository = costRepository;
    }

    public Double getValueAllCostByUnit(String name, LocalDate start_date, LocalDate end_date) {
        Double sum = 0.0;
        System.out.println(name);
        for (Cost cost : costRepository.getAllCostUnit(name)) {
            LocalDate date = LocalDate.parse(cost.getStart_date());
            System.out.println("cost "+ cost.getValue());

            if (date.isAfter(start_date) && date.isBefore(end_date)) {
                sum += cost.getValue();
            }
        }
        return sum;
    }

}
