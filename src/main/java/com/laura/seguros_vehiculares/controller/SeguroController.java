package com.laura.seguros_vehiculares.controller;

import com.laura.seguros_vehiculares.entity.Seguro;
import com.laura.seguros_vehiculares.entity.Vehiculo;
import com.laura.seguros_vehiculares.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguros")
public class SeguroController {
    @Autowired
    private SeguroService seguroService;

    @GetMapping("/list")
    public ResponseEntity<List<Seguro>> listSeguro(){
        List<Seguro> seguros = seguroService.listSeguros();
        return ResponseEntity.ok(seguros);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerSeguro(@RequestBody Seguro seguro){
        Seguro newSeguro = seguroService.registerSeguro(seguro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeguro);
    }

    @PutMapping("/update/{idSeguro}")
    public ResponseEntity<?> updateSeguro(@PathVariable String idSeguro, @RequestBody Seguro seguro){
        try{
            Seguro updateSeguro = new Seguro();
            updateSeguro.setIdSeguro(seguro.getIdSeguro());
            updateSeguro.setCompañia(seguro.getCompañia());
            updateSeguro.setNumeroPoliza(seguro.getNumeroPoliza());
            updateSeguro.setFechaInicio(seguro.getFechaInicio());
            updateSeguro.setFechaVencimiento(seguro.getFechaVencimiento());

            Seguro seguroDB = seguroService.updateSeguro(idSeguro, seguro);
            return ResponseEntity.ok(seguroDB);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idSeguro}")
    public ResponseEntity<?> deleteSeguro(@PathVariable String idSeguro){
        try{
            seguroService.deleteSeguro(idSeguro);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    //@GetMapping("/state/{productState}")
    //public ResponseEntity<List<Product>> listProductsByState(@PathVariable ProductState productState) {
    //    List<Product> products = productService.getProductsByState(productState);
    //    return ResponseEntity.ok(products);
    //}

    @GetMapping("/search/by/vehiculo/{idVehiculo}")
    public ResponseEntity<List<Seguro>> searchSegurosByIdVehiculo(@PathVariable Vehiculo idVehiculo){
        List<Seguro> seguros = seguroService.getSegurosByIdVehiculo(idVehiculo);
        return ResponseEntity.ok(seguros);
    }


}
