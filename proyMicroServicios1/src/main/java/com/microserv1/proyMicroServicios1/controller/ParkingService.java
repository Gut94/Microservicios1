package com.microserv1.proyMicroServicios1.controller;

import java.util.List;

import com.microserv1.proyMicroServicios1.datos.ParkingVehiculos;

public interface ParkingService {

  List<ParkingVehiculos> findAll3();

  void insertParking(ParkingVehiculos park);

  void updateParking(ParkingVehiculos park, Long id);

 // void executeUpdateParking(ParkingVehiculos park);

  void deleteParking(Long id);

}
