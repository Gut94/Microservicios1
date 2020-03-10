package com.microserv1.proyMicroServicios1.datos;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
public class ParkingVehiculos {

  private static final Logger logger = LogManager.getLogger(ParkingVehiculos.class);

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="parkingName")
  String NOMBRE_PARKING;

  @Transient
  int plazasDisponiblesCoches;

  @Transient
  int plazasDisponiblesMotos;

  @Transient
  int plazasDisponiblesBicis;

  @Column(name="plazasCoche")
  int plazasCoches;

  @Column(name="plazasMoto")
  int plazasMotos;

  @Column(name="plazasBici")
  int plazasBicis;

  @Transient
  Boolean admitidoBool = true;

  @Transient
  String admitido;

  @Transient
  String tipoVehiculo;

  @Transient
  String mensajeAceptar;

  @Transient
  String mensajePorColor;

  @Transient
  static final String NOACEPTADO = "NO";

  @Transient
  int numeroVehiculosPorColor;

  public ParkingVehiculos() {

  }

  public ParkingVehiculos(String nombreParking, int X) {

    this.NOMBRE_PARKING = nombreParking;
    this.plazasDisponiblesCoches = X;
    this.plazasDisponiblesMotos = 15;
    this.plazasDisponiblesBicis = 10;
    this.numeroVehiculosPorColor = 0;

    this.plazasCoches = X;
    this.plazasMotos = 15;
    this.plazasBicis = 10;

  }

  public ParkingVehiculos(String nombreParking, int X, int Y) {

    this.NOMBRE_PARKING = nombreParking;
    this.plazasDisponiblesCoches = X;
    this.plazasDisponiblesMotos = Y;
    this.plazasDisponiblesBicis = 10;
    this.numeroVehiculosPorColor = 0;

    this.plazasCoches = X;
    this.plazasMotos = Y;
    this.plazasBicis = 10;

  }

  public String solicitaEntrar(Object o) {

    this.tipoVehiculo = o.getClass().getSimpleName();

    switch (this.tipoVehiculo) {
      case "Coche":

        if (this.plazasDisponiblesCoches == 0) {
          this.admitido = "NO";
          this.admitidoBool = false;
          logger.info(respuestaParking(this.NOMBRE_PARKING, this.tipoVehiculo, this.plazasDisponiblesCoches,
              this.admitidoBool));
          logger.info(((Vehiculo) o).denegar());
        } else {
          this.plazasDisponiblesCoches--;
          this.admitido = "SI";
          this.admitidoBool = true;
          logger.info(respuestaParking(this.NOMBRE_PARKING, this.tipoVehiculo, this.plazasDisponiblesCoches,
              this.admitidoBool));
          logger.info(((Vehiculo) o).aceptar());
        }

        break;

      case "Moto":
        if (this.plazasDisponiblesMotos == 0) {
          this.admitido = "NO";
          this.admitidoBool = false;
          logger.info(
              respuestaParking(this.NOMBRE_PARKING, this.tipoVehiculo, this.plazasDisponiblesMotos, this.admitidoBool));
          logger.info(((Vehiculo) o).denegar());
        } else {
          this.plazasDisponiblesMotos--;
          this.admitido = "SI";
          this.admitidoBool = true;
          logger.info(
              respuestaParking(this.NOMBRE_PARKING, this.tipoVehiculo, this.plazasDisponiblesMotos, this.admitidoBool));
          logger.info(((Vehiculo) o).aceptar());
        }

        break;

      case "Bicicleta":
        if (this.plazasDisponiblesBicis == 0) {
          this.admitido = "NO";
          this.admitidoBool = false;
          logger.info(
              respuestaParking(this.NOMBRE_PARKING, this.tipoVehiculo, this.plazasDisponiblesBicis, this.admitidoBool));
          logger.info(((Vehiculo) o).denegar());
        } else {
          this.plazasDisponiblesBicis--;
          this.admitido = "SI";
          this.admitidoBool = true;
          logger.info(
              respuestaParking(this.NOMBRE_PARKING, this.tipoVehiculo, this.plazasDisponiblesBicis, this.admitidoBool));
          logger.info(((Vehiculo) o).aceptar());
        }

        break;

      default:
        logger.info("Fallo en tipo de vehiculo");
        break;
    }

    return this.admitido;
  }

  // mensaje devuelto del parking con el numero de vehiculos
  public String getnumeroVehiculosPorColor(ArrayList<Vehiculo> vehiculos, String colorString) {

    for (Vehiculo v : vehiculos) {
      if (colorString.equals(v.getColor())) {
        this.numeroVehiculosPorColor++;
      }

    }
    this.mensajePorColor = ("Hay " + this.numeroVehiculosPorColor + " vehiculos color " + colorString);
    return this.mensajePorColor;
  }

  // mensaje devuelto del parking si acepta o no
  public String respuestaParking(String NOMBRE, String tipo, int plazasDisponibles, Boolean admitidoB) {

    String mensajeRespuesta;
    if (admitidoB) {
      mensajeRespuesta = ("Soy el Parking " + NOMBRE + " y acabo de aceptar un/una " + tipo + " me quedan "
          + plazasDisponibles + " plazas disponibles para " + tipo);
    } else {
      mensajeRespuesta = ("Soy el Parking " + NOMBRE + " y acabo de rechazar un/una " + tipo);
    }

    return mensajeRespuesta;
  }

  // ****************************getters

  public int getPlazasDisponiblesBicis() {

    return this.plazasDisponiblesBicis;
  }

  public String getNOMBRE_PARKING() {

    return this.NOMBRE_PARKING;
  }

  public int getPlazasDisponiblesCoches() {

    return this.plazasDisponiblesCoches;
  }

  public int getPlazasDisponiblesMotos() {

    return this.plazasDisponiblesMotos;
  }

  public String getTipoVehiculo() {

    return this.tipoVehiculo;
  }

  public Boolean getAdmitidoBool() {

    return this.admitidoBool;
  }

  // ********************setters

  /**
   * @return plazasCoches
   */
  public int getPlazasCoches() {

    return this.plazasCoches;
  }

  /**
   * @param plazasCoches new value of {@link #getplazasCoches}.
   */
  public void setPlazasCoches(int plazasCoches) {

    this.plazasCoches = plazasCoches;
    this.plazasDisponiblesCoches = plazasCoches;
  }

  /**
   * @return plazasMotos
   */
  public int getPlazasMotos() {

    return this.plazasMotos;
  }

  /**
   * @param plazasMotos new value of {@link #getplazasMotos}.
   */
  public void setPlazasMotos(int plazasMotos) {

    this.plazasMotos = plazasMotos;
    this.plazasDisponiblesMotos = plazasMotos;
  }

  /**
   * @return plazasBicis
   */
  public int getPlazasBicis() {

    return this.plazasBicis;
  }

  /**
   * @param plazasBicis new value of {@link #getplazasBicis}.
   */
  public void setPlazasBicis(int plazasBicis) {

    this.plazasBicis = plazasBicis;
    this.plazasDisponiblesBicis = plazasBicis;
  }

  /**
   * @param nOMBRE_PARKING new value of {@link #getnOMBRE_PARKING}.
   */
  public void setNOMBRE_PARKING(String nOMBRE_PARKING) {

    this.NOMBRE_PARKING = nOMBRE_PARKING;
  }

}
