package com.university.controller;


import com.university.repositories.RevenueRepository;
import com.university.services.CostService;
import com.university.services.RevenueService;
import com.university.services.TerritorialUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/territorialUnit")
public class TerritorialUnitController {

    private final TerritorialUnitService territorialUnitService;
//    private final  CostService costService;
//    private final RevenueService revenueService;
//
//    private final
//    RevenueRepository revenueRepository;

    @Autowired
    public TerritorialUnitController(TerritorialUnitService territorialUnitService
//            ,
//                                     CostService costService, RevenueService revenueService, RevenueRepository revenueRepository
    ) {
        this.territorialUnitService = territorialUnitService;
//        this.costService = costService;
//        this.revenueService = revenueService;
//        this.revenueRepository = revenueRepository;
    }


    @GetMapping(value = "/findTerritorialUnitByName")
    public String ewrwr(Model model) {
        // model.addAttribute("budgetAnalyze");
        return "index";
    }

    @PostMapping(value = "/findTerritorialUnitByName")
    public String findBySearchTerm(@RequestParam String name,
                                   @RequestParam(name = "start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start_date,
                                   @RequestParam(name = "end_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end_date,
                                   Model model) {
//        System.out.println(revenueRepository.getValueAllRevenueByUnit(name));
//        System.out.println(costService.getValueAllCostByUnit(name, start_date, end_date ));
//        System.out.println(revenueService.getValueAllRevenueByUnit(name, start_date, end_date));
        model.addAttribute("budgetAnalyze", territorialUnitService.getAnalyzeBudget(name, start_date, end_date));
        System.out.println(territorialUnitService.getAnalyzeBudget(name, start_date, end_date));
        return "index";
    }

}
