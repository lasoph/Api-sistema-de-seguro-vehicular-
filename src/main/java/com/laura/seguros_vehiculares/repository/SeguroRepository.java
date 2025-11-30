package com.laura.seguros_vehiculares.repository;

import com.laura.seguros_vehiculares.entity.Seguro;
import com.laura.seguros_vehiculares.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, String> {
    Optional<Seguro> findByIdSeguro(String idSeguro);

    List<Seguro> findByIdVehiculo(Vehiculo idVehiculo);
}
