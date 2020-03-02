package com.microserv1.proyMicroServicios1.datos;

import java.util.Random;

public class Moto extends Vehiculo {

  String TIPO_DE_MOTO;

  Random rnd2 = new Random();

  String[] tiposMoto = { "HARLEY", "DUCATI" };

  public Moto() {

    super();

    this.TIPO_DE_MOTO = this.tiposMoto[this.rnd2.nextInt(this.tiposMoto.length)];
  }

  @Override
  public String aceptar() {

    this.mensajeAceptado = ("YUPI, mi color es " + this.COLOR_VEHICULO + " y puedo entrar en el parking. ");
    return this.mensajeAceptado;

  }

  @Override
  public String denegar() {

    this.mensajeRechazado = ("Hey!, soy una " + this.TIPO_DE_MOTO + " y vais a lamentar no haberme dejado pasar. ");
    return this.mensajeRechazado;
  }

  public String getTIPO_DE_MOTO() {

    return this.TIPO_DE_MOTO;
  }

}
