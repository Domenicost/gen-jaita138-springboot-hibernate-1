package com.github.domenicost.demo.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.domenicost.demo.db.entity.SubReddit;
import com.github.domenicost.demo.db.repo.SubRedditRepo;

@Service
public class SubRedditService {

    @Autowired
    private SubRedditRepo subRedditRepo;

    public List<SubReddit> findAll() {
        return subRedditRepo.findAll();
    }

    public SubReddit findById(Long id) {
        return subRedditRepo.findById(id).orElse(null);
    }   

    public SubReddit save(SubReddit subReddit) {
        return subRedditRepo.save(subReddit);
    }

    public void delete(SubReddit subReddit) {
        subRedditRepo.delete(subReddit);
    }
}
