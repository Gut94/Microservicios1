package com.microserv1.proyMicroServicios1.datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProgramaMain {

  private static final Logger logger = LogManager.getLogger(ProgramaMain.class);

  static ParkingVehiculos aparcamiento;

  static Coche coche;

  static Moto moto;

  static Bicicleta bici;

  public static void main(String[] args) {

    String NOMBRE_PARKING;

    int X;
    int Y;

    Random tipoVehiculo = new Random();

    String colorString;

    logger.info("Introduzca nombre del parking: ");
    NOMBRE_PARKING = readString();

    X = numeroCoches();

    Y = numeroMotos(); // si se devuelve -1 es que el string es null o "" por lo que se le asignará Y por defecto

    aparcamiento = iniciarAparcamiento(NOMBRE_PARKING, X, Y); // inicializa el parking tanto por defecto como con numero
                                                              // de bicis

    ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    vehiculos = asignarAparcamiento(tipoVehiculo); // Introduce vehiculos hasta que no quepan más bicis

    colorString = leerColor(); // introduce el color por consola

    logger.info(aparcamiento.getnumeroVehiculosPorColor(vehiculos, colorString));

    // Fin de main **********************************
  }

  static String readString() // lee un string por consola
  {

    String cadenaLeida = null;

    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      cadenaLeida = in.readLine();
    } catch (IOException e) {

      logger.info(e);

    }

    return cadenaLeida;
  }

  static String leerColor() { // introduce el color por consola

    String colorString;

    String[] colores = { "Azul", "Blanco", "Negro", "Rosa" };

    logger.info("Introduzca color para ver el numero de vehiculos(Azul,Blanco,Negro,Rosa): ");
    colorString = readString();

    if (colorString != null && !colorString.isEmpty()) {
      if (colorString.equals("") || !(Arrays.asList(colores).contains(colorString))) {
        while (colorString.equals("") || !(Arrays.asList(colores).contains(colorString))) {
          logger.info("Valor incorrecto: ");
          colorString = readString();

        }
      }
    }
    return colorString;

  }

  static int numeroMotos() // introduce el numero de plazas de parking de motos por consola
  {

    int y;
    String Y_Aux;
    logger.info("Introduzca  numero de plazas de moto (en blanco para valor por defecto): ");
    Y_Aux = readString();

    if (Y_Aux != null && !Y_Aux.isEmpty()) {
      if (Y_Aux.equals("")) {
        y = -1; // numero de plazas de moto por defecto
      } else {
        y = Integer.parseInt(Y_Aux); // numero de plazas de moto
      }
    } else {
      y = -1;
    }

    return y;
  }

  static int numeroCoches() // introduce el numero de plazas de parking de coches por consola
  {

    String X_Aux;
    logger.info("Introduzca numero de plazas de coche: ");

    X_Aux = readString();
    if (X_Aux != null && !X_Aux.isEmpty() || X_Aux.equals("")) {
      while (X_Aux.equals("")) {
        logger.info("No puede estar vacio: ");
        X_Aux = readString();
      }

    }

    return Integer.parseInt(X_Aux); // numero de plazas de coche
  }

  public static ParkingVehiculos iniciarAparcamiento(String nombre, int x, int y) {

    if (y != -1) {
      aparcamiento = new ParkingVehiculos(nombre, x, y);
    } else {
      aparcamiento = new ParkingVehiculos(nombre, x);
    }
    return aparcamiento;

  }

  public static ArrayList<Vehiculo> asignarAparcamiento(Random tipoVehiculo) {

    ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    int numeroSeleccion;
    final String solicitud = "SI";

    while (aparcamiento.getPlazasDisponiblesBicis() != 0) {
      numeroSeleccion = tipoVehiculo.nextInt(3);

      switch (numeroSeleccion) {
        case 0:
          coche = new Coche();
          if (solicitud.equals(aparcamiento.solicitaEntrar(coche))) {
            vehiculos.add(coche);
          }
          break;

        case 1:
          moto = new Moto();
          if (solicitud.equals(aparcamiento.solicitaEntrar(moto))) {
            vehiculos.add(moto);
          }
          break;

        case 2:
          bici = new Bicicleta();
          if (solicitud.equals(aparcamiento.solicitaEntrar(bici))) {
            vehiculos.add(bici);
          }
          break;

        default:
          logger.info("Error del aleatorio");
          break;

      }

    }
    return vehiculos;
  }

}
