package com.laura.seguros_vehiculares.service;


import com.laura.seguros_vehiculares.entity.Conductor;

import java.util.List;
import java.util.Optional;

public interface ConductorService {
    Conductor registerConductor(Conductor conductor);

    List<Conductor> listConductores();

    Optional<Conductor> searchConductorById(Long idConductor);

    Conductor updateConductor(Long idConductor, Conductor conductor);

    void deleteConductor(Long idConductor);
}
