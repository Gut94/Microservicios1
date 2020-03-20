package com.microserv1.proyMicroServicios1.datos;

import java.util.List;

public interface ParkingDao {

  List<ParkingVehiculos> findAll2();

  void insertParking(ParkingVehiculos park);

  void updateParking(Long id, ParkingVehiculos park);

  //void executeUpdateParking(ParkingVehiculos park);

  public void deleteParking(Long id);
}
