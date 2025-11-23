package com.laura.seguros_vehiculares.contoller;


import com.laura.seguros_vehiculares.entity.Vehiculo;
import com.laura.seguros_vehiculares.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/list")
    public ResponseEntity<List<Vehiculo>> listVehiculo(){
        List<Vehiculo> vehiculos = vehiculoService.listVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerVehiculo(@RequestBody Vehiculo vehiculo){
        Vehiculo newVehiculo = vehiculoService.registerVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehiculo);
    }

    @PutMapping("/update/{idVehiculo}")
    public ResponseEntity<?> updateVehiculo(@PathVariable Long idVehiculo, @RequestBody Vehiculo vehiculo){
        try{
            Vehiculo updateVehiculo = new Vehiculo();
            updateVehiculo.setPlaca(vehiculo.getPlaca());
            updateVehiculo.setMarca(vehiculo.getMarca());
            updateVehiculo.setModelo(vehiculo.getModelo());
            updateVehiculo.setAño(vehiculo.getAño());
            updateVehiculo.setColor(vehiculo.getColor());

            Vehiculo vehiculoDB = vehiculoService.updateVehiculo(idVehiculo, vehiculo);
            return ResponseEntity.ok(vehiculoDB);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idVehiculo}")
    public ResponseEntity<?> deleteVehiculo(@PathVariable Long idVehiculo){
        try{
            vehiculoService.deleteVehiculo(idVehiculo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

}
