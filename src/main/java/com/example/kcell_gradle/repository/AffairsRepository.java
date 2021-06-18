package com.example.kcell_gradle.repository;

import com.example.kcell_gradle.models.Affairs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AffairsRepository extends JpaRepository<Affairs, Long> {
    //TODO write findAffairsByDate, write service with request scope
    List<Affairs> findAffairsByAffairDate(LocalDate affairDate);
}


