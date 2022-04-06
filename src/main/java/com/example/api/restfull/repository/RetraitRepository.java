package com.example.api.restfull.repository;

import com.example.api.restfull.model.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetraitRepository extends JpaRepository<Retrait , Long> {

}
