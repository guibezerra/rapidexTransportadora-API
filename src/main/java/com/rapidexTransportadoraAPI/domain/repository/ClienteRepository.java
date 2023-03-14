package com.rapidexTransportadoraAPI.domain.repository;

import com.rapidexTransportadoraAPI.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
