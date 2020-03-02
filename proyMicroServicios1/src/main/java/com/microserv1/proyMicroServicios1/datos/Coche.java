package com.microserv1.proyMicroServicios1.datos;

public class Coche extends Vehiculo {

  public Coche() {

    super();

  }

  @Override
  public String aceptar() {

    this.mensajeAceptado = ("BROOM ! BROOM !, mi color es " + this.COLOR_VEHICULO + " y puedo entrar en el parking. ");
    return this.mensajeAceptado;
  }

}
