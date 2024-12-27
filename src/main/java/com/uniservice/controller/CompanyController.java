package com.uniservice.controller;

import com.uniservice.dto.CompanyDTO;
import com.uniservice.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/onboard")
    public ResponseEntity<String> onboardCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        companyService.onboardCompany(companyDTO);
        return ResponseEntity.ok("Company onboarded successfully!");
    }
}