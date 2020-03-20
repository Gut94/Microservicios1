package com.microserv1.proyMicroServicios1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microserv1.proyMicroServicios1.datos.Parametros;

@RestController
public class Controlador {

  // private String modelo=
  // "C:\\Users\\ranavarr\\Desktop\\devon\\Devon-dist_3.1.0\\ServerDevonProyecto1RN\\core\\src\\main\\resources\\templates\\parking";
  // public static String [] parametros1 = {"Parking","azul","15","10"};
  @Autowired
  Servicio servicio;

  public Controlador() {

    super();
  }
  
  @GetMapping(value = "") // mensaje de inicio para evitar error
  public String inicio() {

    return "Backend, usar Postman";
  }
  
  @GetMapping(value = "/parking") // cuando usas get
  public @ResponseBody ResponseEntity<Object> getparking() {

    return new ResponseEntity<>(this.servicio.getMapa(), HttpStatus.ACCEPTED);
  }

  @PostMapping(value = "/parking") // cuando usas post
  public @ResponseBody ResponseEntity<Object> parkingpost(@RequestBody Parametros parametros) {

    this.servicio.servicioRunParking(parametros);

    return new ResponseEntity<>(this.servicio.getMapa(), HttpStatus.ACCEPTED);

  }

  // @GetMapping("/hola")
  // public String hola() {
  //
  // return "hola";
  // }

}
