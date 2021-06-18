package com.example.kcell_gradle.controller;
/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */
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

/*
*
* This is main controller, there are I created all rest requests with using CRUD operations
*
* */

/*We defined that is rest controller, and we use localhost:9090/affairs to connect and use*/
@RestController
@RequestMapping("/affairs")
@Slf4j
public class AffairsController {
    private final AffairService affairService;

    @Autowired
    AffairsController(AffairService affairService) {
        this.affairService = affairService;
    }

    /*Request with GET method, this method get Some date in body with attribute "affairDate" in format "YYYY-MM-DD"
    , if he find Affair with this date return him, else return all available Affairs, also this only for json */
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    List<Affairs> all(@RequestParam(value = "affairDate", required = false)
                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              LocalDate affairDate) {
        return affairService.findAffairs(affairDate);
    }

    /*This method for plain text*/
    @GetMapping( produces = MediaType.TEXT_PLAIN_VALUE)
    List<Affairs> allXml(@RequestParam(value = "affairDate", required = false)
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                 LocalDate affairDate) {
        return affairService.findAffairs(affairDate);
    }

    /* This method realize that we do some of the Affairs*/
    @PostMapping(value = "/done/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Affairs done(@PathVariable Long id){
     return affairService.changeStatus(id);
    }

    /* This method for adding new Affair into database, also with using json
    * example: {
        "name": "Reading",
        "affairDate": "2021-06-20",
        "attributes": ""
    }
    *
    * */
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    Affairs newAffairs(@RequestBody Affairs newAffairs) {
        return affairService.save(newAffairs);
    }

    /* This method for finding Affairs by id*/
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Affairs one (@PathVariable Long id) {
        return affairService.findById(id);
    }

    /* This method for changing some fields of our Affair*/
    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Affairs replaceEmployee(@RequestBody Affairs newAffairs, @PathVariable Long id) {
        return affairService.replaceEmployee(newAffairs, id);
    }

    /* This method for deleting */
    @DeleteMapping("{id}")
    void deleteAffairs(@PathVariable Long id) {
        affairService.deleteById(id);
    }

}
