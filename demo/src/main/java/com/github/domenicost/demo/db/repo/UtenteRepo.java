package com.github.domenicost.demo.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.domenicost.demo.db.entity.Utente;

@Repository
public interface UtenteRepo extends JpaRepository <Utente, Long> {

    List<Utente> findByNomeStartingWithIgnoreCase(String lettera);
    List<Utente> findByCreditoGreaterThan(int valore);
    List<Utente> findByNomeNullOrCognomeNull();
    List<Utente> findByCreditoBetween(int min, int max);
}

