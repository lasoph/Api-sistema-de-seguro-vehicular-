package com.laura.seguros_vehiculares.service;


import com.laura.seguros_vehiculares.entity.Seguro;
import com.laura.seguros_vehiculares.entity.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface SeguroService {

    Seguro registerSeguro(Seguro seguro);

    List<Seguro> listSeguros();

    Optional<Seguro> searchSeguroById(String idSeguro);

    Seguro updateSeguro(String idSeguro, Seguro seguro);

    void deleteSeguro(String idSeguro);

    List<Seguro> getSegurosByIdVehiculo(Vehiculo idVehiculo);

}
