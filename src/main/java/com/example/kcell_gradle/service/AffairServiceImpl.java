package com.example.kcell_gradle.service;

import com.example.kcell_gradle.exception.AffairsNotFoundException;
import com.example.kcell_gradle.models.Affairs;
import com.example.kcell_gradle.repository.AffairsRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AffairServiceImpl implements AffairService {

    private AffairsRepository affairsRepository;

    public AffairServiceImpl(AffairsRepository affairsRepository) {
        this.affairsRepository = affairsRepository;
    }

    @Override
    public List<Affairs> findAffairs(LocalDate affairDate) {
        if (Objects.nonNull(affairDate)) {
            return affairsRepository.findAffairsByAffairDate(affairDate);
        }
        return affairsRepository.findAll();
    }

    @Override
    public Affairs findById(Long id) {
        return affairsRepository.findById(id)
                .orElseThrow(() -> new AffairsNotFoundException(id));
    }

    @Override
    public Affairs replaceEmployee(Affairs newAffairs, Long id) {
        return affairsRepository.findById(id)
                .map(affairs -> {
                    affairs.setName(newAffairs.getName());
                    affairs.setAttributes(newAffairs.getAttributes());
                    affairs.setDone(newAffairs.isDone());
                    return affairsRepository.save(affairs);
                }).orElseGet(() -> {
                    newAffairs.setId(id);
                    return affairsRepository.save(newAffairs);
                });
    }

    @Override
    public Affairs save(Affairs newAffairs) {
        return affairsRepository.save(newAffairs);
    }

    @Override
    public void deleteById(Long id) {
        affairsRepository.deleteById(id);
    }

    @Override
    public Affairs changeStatus(Long id) {
        Affairs tmpAffairs = findById(id);
        tmpAffairs.setDone(true);
        return replaceEmployee(tmpAffairs,id);
    }
}
