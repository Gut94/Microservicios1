package com.microserv1.proyMicroServicios1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microserv1.proyMicroServicios1.datos.ParkingVehiculos;

@CrossOrigin("*")
@RestController
public class ControladorSQL {

  private String modelo = "C:\\Users\\dtriasra\\Downloads\\devon\\Devon-dist_3.1.0\\ServerDtriasra\\core\\src\\main\\resources\\tparklates\\parking";

  public static String[] parametros1 = { "Diego", "azul", "15", "10" };

  // @Autowired
  // Servicio servicio;

  @Autowired
  ParkingService parkingService;

  public ControladorSQL() {

    super();
  }
  /*
   * @GetMapping(value = "/parking") public @ResponseBody ResponseEntity<Object> getparking() {
   *
   * return new ResponseEntity<>(this.parkingService.findAll(), HttpStatus.ACCEPTED); }
   *
   * @PostMapping(value = "/parking") public @ResponseBody ResponseEntity<Object> parkingpost(@RequestBody Parametros
   * parametros) {
   *
   * return new ResponseEntity<>(this.servicio.postMethod(parametros), HttpStatus.ACCEPTED); }
   */
  // Lista de Parkings

  @GetMapping(value = "/parkingList")
  public @ResponseBody ResponseEntity<Object> getParkings() {

    return new ResponseEntity<>(this.parkingService.findAll(), HttpStatus.ACCEPTED);
  }

  // Crea nuevo parking en db
  @PostMapping(value = "/createParking")
  public @ResponseBody ResponseEntity<Object> createParking(@RequestBody ParkingVehiculos park) {

    this.parkingService.insertParking(park);
    return new ResponseEntity<>("creando parking: " + park.getNOMBRE_PARKING(), HttpStatus.ACCEPTED);
  }

  // Actualiza un parking en db
  @PutMapping(value = "/updateParking")
  public @ResponseBody ResponseEntity<Object> updateParking(@RequestBody ParkingVehiculos park) {

    this.parkingService.updateParking(park);
    return new ResponseEntity<>("Actualizando todo el parking:" + park.getNOMBRE_PARKING(), HttpStatus.ACCEPTED);
  }

  // Actualiza un parking en db usando template.execute (ni idea xd)
  @PutMapping(value = "/executeUpdateParking")
  public @ResponseBody ResponseEntity<Object> executeUpdateParking(@RequestBody ParkingVehiculos park) {

    this.parkingService.executeUpdateParking(park);
    return new ResponseEntity<>("Actualizando parte del parking: " + park.getNOMBRE_PARKING(), HttpStatus.ACCEPTED);
  }

  // Borra Parking en db
  @DeleteMapping(value = "/deleteParkingById")
  public @ResponseBody ResponseEntity<Object> deleteParking(@RequestBody ParkingVehiculos park) {

    this.parkingService.deleteParking(park);
    return new ResponseEntity<>("Borrando parking: " + park.getNOMBRE_PARKING(), HttpStatus.ACCEPTED);
  }
}
