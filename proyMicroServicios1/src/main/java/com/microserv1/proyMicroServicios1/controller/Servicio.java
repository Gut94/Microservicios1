package com.microserv1.proyMicroServicios1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.microserv1.proyMicroServicios1.datos.Parametros;
import com.microserv1.proyMicroServicios1.datos.ParkingVehiculos;
import com.microserv1.proyMicroServicios1.datos.ProgramaMain;
import com.microserv1.proyMicroServicios1.datos.Vehiculo;

@Service
public class Servicio {

  // private List<Cualidades> cualidades = new ArrayList<Cualidades>();

  // private ClaseFrankestein valores;

  // static String[] colores = {"azul", "blanco", "negro", "rosa"};

  Map<String, Integer> parkings = new HashMap<String, Integer>();

  static List<ParkingVehiculos> lista = new ArrayList<>();

  public Servicio() {

    super();
  }

  public String servicioRunParking(Parametros parametros) {

    final Logger LOGGER1 = LogManager.getLogger(Servicio.class);

    LOGGER1.info("Nombre: {} , Color: {} coches: {}. motos: {}", parametros.getNombre(), parametros.getColorBuscado(),
        parametros.getNumeroCoches(), parametros.getNumeroMotos());

    ParkingVehiculos parkingPrincipal = ProgramaMain.iniciarAparcamiento(parametros.getNombre(),
        parametros.getNumeroCoches(), parametros.getNumeroMotos());

    // llena el parking de vehiculos
    Random tipoVehiculo = new Random();
    ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    vehiculos = ProgramaMain.asignarAparcamiento(tipoVehiculo);
    int numVehiculos = vehiculos.size();

    lista.add(parkingPrincipal);

    LOGGER1.info(" " + parkingPrincipal.getNOMBRE_PARKING() + " " + numVehiculos);
    LOGGER1.info("----------------------------------------------------------------- ");

    this.parkings.put(parkingPrincipal.getNOMBRE_PARKING(), numVehiculos);

    return parkingPrincipal.getNOMBRE_PARKING();

  }

  public List<ParkingVehiculos> getLista() {

    return Servicio.lista;
  }

  public Map<String, Integer> getMapa() {

    return this.parkings;
  }
}
