package com.microserv1.proyMicroServicios1.controller;

import java.util.List;

import com.microserv1.proyMicroServicios1.datos.ParkingVehiculos;

public interface ParkingService {

  List<ParkingVehiculos> findAll();

  void insertParking(ParkingVehiculos park);

  void updateParking(ParkingVehiculos park);

  void executeUpdateParking(ParkingVehiculos park);

  void deleteParking(ParkingVehiculos park);

}
