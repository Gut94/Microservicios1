package com.microserv1.proyMicroServicios1.datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ParkingRowMapper implements RowMapper<ParkingVehiculos> {

  @Override
  public ParkingVehiculos mapRow(ResultSet rs, int rowNumber) throws SQLException {

    // int plazasPorDefecto = 1;
    // String nombrePorDefecto = "p_motos";

    ParkingVehiculos park = new ParkingVehiculos();
    // park.setNombre(rs.getString(1));
    // park.setPlazasCoche(rs.getInt(2));
    // park.setPlazasMoto(rs.getInt(3));
    // park.setPlazasBici(rs.getInt(4));

    park.setNOMBRE_PARKING(rs.getString("parkingName"));
    park.setPlazasCoches(rs.getInt("plazasCoche"));
    park.setPlazasMotos(rs.getInt("plazasMoto"));
    park.setPlazasBicis(rs.getInt("plazasBici"));

    return park;
  }

}
