package com.laura.seguros_vehiculares.service;

import com.laura.seguros_vehiculares.entity.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    Vehiculo registerVehiculo(Vehiculo vehiculo);

    List<Vehiculo> listVehiculos();

    Optional<Vehiculo> searchVehiculoById(Long idVehiculo);

    Vehiculo updateVehiculo(Long idVehiculo, Vehiculo vehiculo);

    void deleteVehiculo(Long idVehiculo);
}
