package com.example.kcell_gradle.service;
/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */
import com.example.kcell_gradle.models.Affairs;
import java.time.LocalDate;
import java.util.List;

/*
*
* In this files I realized all methods, witch I needed in rest controller. With services, we don't use repositories directly
*
* */

public interface AffairService {
   List<Affairs> findAffairs(LocalDate affairDate);
   Affairs findById(Long id);
   Affairs replaceEmployee(Affairs newAffairs,Long id);
   Affairs save (Affairs newAffairs);
   void deleteById (Long id);
   Affairs changeStatus(Long id);
}
