package com.github.domenicost.demo.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.domenicost.demo.db.entity.Role;

public interface RoleRepo extends JpaRepository <Role, Long> {

}
