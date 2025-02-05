package com.github.domenicost.demo.db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.domenicost.demo.db.entity.SubReddit;

public interface SubRedditRepo extends JpaRepository <SubReddit, Long> {

}
