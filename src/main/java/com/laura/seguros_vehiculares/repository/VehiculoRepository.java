package com.laura.seguros_vehiculares.repository;

import com.laura.seguros_vehiculares.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{
    Optional<Vehiculo> findByIdVehiculo(Long idVehiculo);
}
