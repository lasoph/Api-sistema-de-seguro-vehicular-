package com.laura.seguros_vehiculares.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {

    @Id
    @Column(name = "id_seguro", nullable = false)
    private String idSeguro;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo", nullable = false)
    private Vehiculo idVehiculo;

    @Column(name = "compañia", nullable = false, length = 100)
    private String compañia;

    @Column(name = "numero_poliza", nullable = false)
    private String numeroPoliza;

    @Column(name = "fecha_inicio", nullable = false, length = 50)
    private String fechaInicio;

    @Column(name = "fecha_vencimiento", nullable = false, length = 50)
    private String fechaVencimiento;

}