package com.microserv1.proyMicroServicios1.datos;

import java.util.Random;

public class Vehiculo {

  protected String COLOR_VEHICULO;

  String mensajeAceptado;

  String mensajeRechazado;

  String[] colores = { "Azul", "Blanco", "Negro", "Rosa" };

  public Vehiculo() {

    Random rnd = new Random();
    int n = rnd.nextInt(this.colores.length);
    this.COLOR_VEHICULO = this.colores[n];
  }

  public String aceptar() {

    this.mensajeAceptado = ("Genial, puedo entrar en un parking. ");
    return this.mensajeAceptado;

  }

  public String denegar() {

    this.mensajeRechazado = ("Maldita sea!, no puedo entrar en el parking. ");
    return this.mensajeRechazado;
  }

  public String getColor() {

    return this.COLOR_VEHICULO;
  }

}
