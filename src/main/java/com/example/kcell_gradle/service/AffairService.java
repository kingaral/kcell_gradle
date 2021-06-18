package com.example.kcell_gradle.service;

import com.example.kcell_gradle.models.Affairs;
import java.time.LocalDate;
import java.util.List;

public interface AffairService {
   List<Affairs> findAffairs(LocalDate affairDate);
   Affairs findById(Long id);
   Affairs replaceEmployee(Affairs newAffairs,Long id);
   Affairs save (Affairs newAffairs);
   void deleteById (Long id);
   Affairs changeStatus(Long id);
}
