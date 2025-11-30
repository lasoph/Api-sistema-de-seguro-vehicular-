package com.laura.seguros_vehiculares.service.implementacion;


import com.laura.seguros_vehiculares.entity.Seguro;
import com.laura.seguros_vehiculares.entity.Vehiculo;
import com.laura.seguros_vehiculares.repository.SeguroRepository;
import com.laura.seguros_vehiculares.service.SeguroService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroServiceImpl implements SeguroService {
    @Autowired
    private SeguroRepository seguroRepository;

    @Override
    public Seguro registerSeguro(Seguro seguro) {
        return seguroRepository.save(seguro);
    }

    @Override
    public List<Seguro> listSeguros() {
        return seguroRepository.findAll();
    }

    @Override
    public Optional<Seguro> searchSeguroById(String idSeguro) {
        return seguroRepository.findByIdSeguro(idSeguro);
    }

    @SneakyThrows
    @Override
    public Seguro updateSeguro(String idSeguro, Seguro seguro) {
        Seguro seguroExisting = seguroRepository.findByIdSeguro(idSeguro)
                .orElseThrow(()-> new Exception("Seguro con el id"+ idSeguro+"no encontrado"));

        seguroExisting.setIdVehiculo(seguro.getIdVehiculo());
        seguroExisting.setCompañia(seguro.getCompañia());
        seguroExisting.setNumeroPoliza(seguro.getNumeroPoliza());
        seguroExisting.setFechaInicio(seguro.getFechaInicio());
        seguroExisting.setFechaVencimiento(seguro.getFechaVencimiento());

        return seguroRepository.save(seguroExisting);
    }

    @SneakyThrows
    @Override
    public void deleteSeguro(String idSeguro) {
        Seguro seguroExisting = seguroRepository.findByIdSeguro(idSeguro)
                .orElseThrow(()-> new Exception("Seguro con el id"+ idSeguro+"no encontrado"));

        seguroRepository.deleteById(idSeguro);
    }

    @Override
    public List<Seguro> getSegurosByIdVehiculo(Vehiculo idVehiculo) {
        return seguroRepository.findByIdVehiculo(idVehiculo);
    }
}
