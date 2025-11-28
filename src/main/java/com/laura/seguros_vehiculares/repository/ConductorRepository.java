package com.laura.seguros_vehiculares.repository;

import com.laura.seguros_vehiculares.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByIdConductor(Long idVehiculo);
}
