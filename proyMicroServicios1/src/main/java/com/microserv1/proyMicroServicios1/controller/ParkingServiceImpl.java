package com.microserv1.proyMicroServicios1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microserv1.proyMicroServicios1.datos.ParkingDao;
import com.microserv1.proyMicroServicios1.datos.ParkingVehiculos;

@Service
public class ParkingServiceImpl implements ParkingService {
  @Autowired
  ParkingDao parkingDao;

  @Override
  public List<ParkingVehiculos> findAll3() {

    return this.parkingDao.findAll2();
  }

  @Override
  public void insertParking(ParkingVehiculos park) {

    this.parkingDao.insertParking(park);

  }

  @Override
  public void updateParking(ParkingVehiculos park, Long id) {

    this.parkingDao.updateParking(id, park);

  }

  /*@Override
  public void executeUpdateParking(ParkingVehiculos park) {

    this.parkingDao.executeUpdateParking(park);

  }*/

  @Override
  public void deleteParking(Long id) {

    this.parkingDao.deleteParking(id);

  }

}
