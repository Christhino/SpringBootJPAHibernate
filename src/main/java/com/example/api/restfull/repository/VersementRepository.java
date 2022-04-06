package com.example.api.restfull.repository;


import com.example.api.restfull.model.Versement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersementRepository extends JpaRepository<Versement, Long> {
}
