package com.laura.seguros_vehiculares.service.implementacion;


import com.laura.seguros_vehiculares.entity.Vehiculo;
import com.laura.seguros_vehiculares.repository.VehiculoRepository;
import com.laura.seguros_vehiculares.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired

    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registerVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> searchVehiculoById(Long idVehiculo) {
        return vehiculoRepository.findByIdVehiculo(idVehiculo);
    }

    @SneakyThrows
    @Override
    public Vehiculo updateVehiculo(Long idVehiculo, Vehiculo vehiculo) {
        Vehiculo vehiculoExisting = vehiculoRepository.findByIdVehiculo(idVehiculo)
                .orElseThrow(()->new Exception("Vehiculo con el id"+ idVehiculo + "no encontrado"));

        vehiculoExisting.setPlaca(vehiculo.getPlaca());
        vehiculoExisting.setMarca(vehiculo.getMarca());
        vehiculoExisting.setModelo(vehiculo.getModelo());
        vehiculoExisting.setAño(vehiculo.getAño());
        vehiculoExisting.setColor(vehiculo.getColor());

        return vehiculoRepository.save(vehiculoExisting);
    }

    @SneakyThrows
    @Override
    public void deleteVehiculo(Long idVehiculo) {
        Vehiculo vehiculoExisting = vehiculoRepository.findByIdVehiculo(idVehiculo)
                .orElseThrow(()->new Exception("Vehiculo con el id"+ idVehiculo + "no encontrado"));

        vehiculoRepository.deleteById(idVehiculo);
    }
}
