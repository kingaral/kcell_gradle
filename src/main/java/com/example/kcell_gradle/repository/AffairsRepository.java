package com.example.kcell_gradle.repository;
/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */
/* Here I added my inMemory Database, it's JpaRepository, and also added method findAffairsByAffairDate for searching Affairs by date.
* */
import com.example.kcell_gradle.models.Affairs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AffairsRepository extends JpaRepository<Affairs, Long> {
    List<Affairs> findAffairsByAffairDate(LocalDate affairDate);
}


