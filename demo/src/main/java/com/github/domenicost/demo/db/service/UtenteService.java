package com.github.domenicost.demo.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.domenicost.demo.db.entity.Utente;
import com.github.domenicost.demo.db.repo.UtenteRepo;

@Service
public class UtenteService {

        @Autowired
        private UtenteRepo utenteRepo;
    
        public List<Utente> findAll() {
            return utenteRepo.findAll();
        }
    
        public void save(Utente utente) {
            utenteRepo.save(utente);
        }
    
        public void delete(Utente utente) {
            utenteRepo.delete(utente);
        }
    
        public Utente findById(Long id) {
            return utenteRepo.findById(id).orElse(null);
        }
    
        public List<Utente> findByNomeStartingWithA() {
            return utenteRepo.findByNomeStartingWithIgnoreCase("a");
        }
    
        public List<Utente> findByCreditoGreatherThan10() {
            return utenteRepo.findByCreditoGreaterThan(10 * 100);
        }
    
        public List<Utente> findByNomeNullOrCognomeNull() {
            return utenteRepo.findByNomeNullOrCognomeNull();
        }
    
        public List<Utente> findyByCreditoBetween0And10() {
            return utenteRepo.findByCreditoBetween(0, 10 * 100);
        }
    }