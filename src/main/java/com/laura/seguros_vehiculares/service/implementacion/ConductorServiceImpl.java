package com.laura.seguros_vehiculares.service.implementacion;

import com.laura.seguros_vehiculares.entity.Conductor;
import com.laura.seguros_vehiculares.repository.ConductorRepository;
import com.laura.seguros_vehiculares.service.ConductorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired

    private ConductorRepository conductorRepository;


    @Override
    public Conductor registerConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public List<Conductor> listConductores() {
        return conductorRepository.findAll();
    }

    @Override
    public Optional<Conductor> searchConductorById(Long idConductor) {
        return conductorRepository.findByIdConductor(idConductor);
    }

    @SneakyThrows
    @Override
    public Conductor updateConductor(Long idConductor, Conductor conductor) {
        Conductor conductorExisting = conductorRepository.findByIdConductor(idConductor)
                .orElseThrow(()->new Exception("Conductor con el id"+ idConductor+"no encontrado"));

        conductorExisting.setNombre(conductor.getNombre());
        conductorExisting.setLicencia(conductor.getLicencia());
        conductorExisting.setTelefono(conductor.getTelefono());
        conductorExisting.setDireccion(conductor.getDireccion());
        conductorExisting.setActivo(conductor.isActivo());

        return conductorRepository.save(conductorExisting);
    }

    @SneakyThrows
    @Override
    public void deleteConductor(Long idConductor) {
        Conductor conductorExisting = conductorRepository.findByIdConductor(idConductor)
                .orElseThrow(()->new Exception("Conductor con el id"+ idConductor+"no encontrado"));

        conductorRepository.deleteById(idConductor);
    }
}
