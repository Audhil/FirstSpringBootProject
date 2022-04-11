package com.medium.audhil.covidcases.controllers;

import com.medium.audhil.covidcases.models.LocationStats;
import com.medium.audhil.covidcases.services.CovidDataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CovidController {

  @Autowired
  CovidDataService coronaVirusDataService;

  @GetMapping("/")
  public String home(Model model) {
    List<LocationStats> allStats = coronaVirusDataService.getAllStats();
    int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
    int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
    model.addAttribute("locationStats", allStats);
    model.addAttribute("totalReportedCases", totalReportedCases);
    model.addAttribute("totalNewCases", totalNewCases);
    return "home";  //  for designing html, refer - thymeleaf(https://www.thymeleaf.org/), bootstrap(https://getbootstrap.com/docs/3.4/css/) for css,
  }
}