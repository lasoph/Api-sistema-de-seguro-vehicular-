package com.laura.seguros_vehiculares.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conductor")
    private Long idConductor;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "licencia", nullable = false, length = 100)
    private String licencia;

    @Column(name = "telefono", nullable = false, length = 50)
    private String telefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "activo", nullable = false)
    private boolean activo;

}