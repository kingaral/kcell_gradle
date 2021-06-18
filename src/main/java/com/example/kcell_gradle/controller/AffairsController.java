package com.example.kcell_gradle.controller;

import com.example.kcell_gradle.models.Affairs;
import com.example.kcell_gradle.service.AffairService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/affairs")
@Slf4j
public class AffairsController { //TODO mvcConfig w
    // TODO @Configuration vs @Component vs @Bean vs @Service, service write with request scope, mvcController
    private final AffairService affairService;

    @Autowired
    AffairsController(AffairService affairService) {
        this.affairService = affairService;
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('admin')")
    List<Affairs> all(@RequestParam(value = "affairDate", required = false)
                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              LocalDate affairDate) {
        return affairService.findAffairs(affairDate);
    }

    @GetMapping( produces = MediaType.TEXT_PLAIN_VALUE)
    @PreAuthorize("hasAnyAuthority('admin')")
    List<Affairs> allXml(@RequestParam(value = "affairDate", required = false)
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                 LocalDate affairDate) {
        return affairService.findAffairs(affairDate);
    }

    @PostMapping(value = "/done/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Affairs done(@PathVariable Long id){

     return affairService.changeStatus(id);
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    Affairs newAffairs(@RequestBody Affairs newAffairs) {
        return affairService.save(newAffairs);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Affairs one (@PathVariable Long id) {
        return affairService.findById(id);
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Affairs replaceEmployee(@RequestBody Affairs newAffairs, @PathVariable Long id) {
        return affairService.replaceEmployee(newAffairs, id);
    }

    @DeleteMapping("{id}")
    void deleteAffairs(@PathVariable Long id) {
        affairService.deleteById(id);
    }

}
