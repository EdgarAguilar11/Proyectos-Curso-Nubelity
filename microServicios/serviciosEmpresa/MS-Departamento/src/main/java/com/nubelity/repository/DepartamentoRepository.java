package com.nubelity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubelity.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
