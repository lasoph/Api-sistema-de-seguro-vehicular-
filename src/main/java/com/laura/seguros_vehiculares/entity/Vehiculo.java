package com.laura.seguros_vehiculares.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;

    @Column(name = "placa", nullable = false , length = 100)
    private String placa;

    @Column(name = "marca", nullable= false)
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name= "año", nullable = false)
    private Integer año;

    @Column(name = "color")
    private String color;

    @OneToOne
    @JoinColumn(name = "id_conductor", referencedColumnName = "id_conductor", nullable = false)
    private Conductor conductor;

}
