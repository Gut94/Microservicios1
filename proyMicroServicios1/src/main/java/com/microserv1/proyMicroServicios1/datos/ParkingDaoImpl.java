package com.microserv1.proyMicroServicios1.datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
//buscar otra forma 2
@Repository
public class ParkingDaoImpl implements ParkingDao {

  private static final Logger logger = LogManager.getLogger(ParkingVehiculos.class);

  NamedParameterJdbcTemplate template;

  public ParkingDaoImpl(NamedParameterJdbcTemplate template) {

    this.template = template;
  }

  @Override
  public List<ParkingVehiculos> findAll() {

    return this.template.query("select * from parking", new ParkingRowMapper());
  }

  @Override
  public void insertParking(ParkingVehiculos park) {

    // Codigo sql
    final String sql = "insert into parking(parkingName, plazasCoche , plazasMoto, plazasBici) values(:parkingName,:plazasCoche,:plazasMoto,:plazasBici)";
    // Esto no se que hace
    KeyHolder holder = new GeneratedKeyHolder();
    // Para mapear los parametros introducidos al sql
    SqlParameterSource param = new MapSqlParameterSource().addValue("parkingName", park.getNOMBRE_PARKING())
        .addValue("plazasCoche", park.getPlazasCoches()).addValue("plazasMoto", park.getPlazasMotos())
        .addValue("plazasBici", park.getPlazasBicis());
    this.template.update(sql, param, holder);
    logger.info("insert parking {}", park.getNOMBRE_PARKING());
  }

  @Override
  public void updateParking(ParkingVehiculos park) {

    final String sql = "update parking set plazasCoche=:plazasCoche, plazasBici=:plazasBici, plazasMoto=:plazasMoto where parkingName=:parkingName";
    KeyHolder holder = new GeneratedKeyHolder();
    SqlParameterSource param = new MapSqlParameterSource().addValue("parkingName", park.getNOMBRE_PARKING())
        .addValue("plazasCoche", park.getPlazasCoches()).addValue("plazasMoto", park.getPlazasMotos())
        .addValue("plazasBici", park.getPlazasBicis());
    this.template.update(sql, param, holder);
    logger.info("update parking {}", park.getNOMBRE_PARKING());
  }

  @Override
  public void executeUpdateParking(ParkingVehiculos park) {

    final String sql = "update parking set plazasCoche=:plazasCoche, plazasBici=:plazasBici, plazasMoto=:plazasMoto where parkingName=:parkingName";
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("parkingName", park.getNOMBRE_PARKING());
    map.put("plazasCoche", park.getPlazasCoches());
    map.put("plazasMoto", park.getPlazasMotos());
    map.put("plazasBici", park.getPlazasBicis());

    this.template.execute(sql, map, new PreparedStatementCallback<Object>() {
      @Override
      public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

        return ps.executeUpdate();
      }
    });
    logger.info("execute parking {}", park.getNOMBRE_PARKING());
  }

  @Override
  public void deleteParking(ParkingVehiculos park) {

	  final String sql = "delete from parking where parkingName=:parkingName";
	  Map<String,Object> map=new HashMap<String,Object>();  
	  map.put("parkingName", park.getNOMBRE_PARKING());
	  template.execute(sql,map,new PreparedStatementCallback<Object>() {  
	     @Override  
	     public Object doInPreparedStatement(PreparedStatement ps)  
	             throws SQLException, DataAccessException {  
	         return ps.executeUpdate();  
	     }  
	 });  
    
  }

}
