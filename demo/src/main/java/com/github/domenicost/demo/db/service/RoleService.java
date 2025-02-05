package com.github.domenicost.demo.db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.domenicost.demo.db.entity.Role;
import com.github.domenicost.demo.db.repo.RoleRepo;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public void save(Role role) {
        roleRepo.save(role);
    }

    public void delete(Role role) {
        roleRepo.delete(role);
    }

    public Role findById(Long id) {
        return roleRepo.findById(id).orElse(null);
    }

}
