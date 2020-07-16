package com.m5d5.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.m5d5.beans.Accidente;    

public class AccidenteDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Accidente acci){    
	    String sql="insert into  Accidentes (fecha,hora,suceso,lugar,cliente_id) values ('" + acci.getFecha() + "','" + acci.getHora() + "','" + acci.getSuceso() + "','" + acci.getLugar() +  "','" + acci.getClienteid() +  "')";
	    return template.update(sql);
	}
	
	public int update(Accidente acci){    
	    String sql="UPDATE Accidentes SET fecha = '" + acci.getFecha() + "', hora = '" + acci.getHora() + "', suceso = '" + acci.getSuceso() + "', lugar = '" + acci.getLugar()  + "' WHERE idaccidente = '" + acci.getIdaccidente() +  "'";
	    return template.update(sql);    
	}   
	
	public int delete(int id){    
	    String sql="delete from Accidentes WHERE idaccidente= " + id +"";
	    return template.update(sql);
	}               

	public Accidente getAcciById(int idaccidente){    
	    String sql="select * from Accidentes where idaccidente=?";
	    return template.queryForObject(sql, new Object[]{idaccidente},new BeanPropertyRowMapper<Accidente>(Accidente.class));    
	}
	
	public List<Accidente> getAccidente (){    
	    return template.query("select * from Accidentes",new RowMapper<Accidente>(){    
	        public Accidente mapRow(ResultSet rs, int row) throws SQLException {    
	            Accidente acci=new Accidente(); 
	            acci.setIdaccidente(rs.getInt(1));
				acci.setFecha(rs.getString(2));
				acci.setHora(rs.getString(3));
				acci.setSuceso(rs.getString(4));
				acci.setLugar(rs.getString(5));
				acci.setClienteid(rs.getInt(6));
	            return acci;
	            
	        }    
//      public Accidente CallCount (int cantidad) {
//    	  SimpleJdbcCall simpleJdbcCall = new
//    	 SimpleJdbcCall(Accidente).withCount("sp_cuentaTotalAccidentesPorCliente");
//    	  SqlParameterSource in = new MapSqlParameterSource().addValue("count",cantidad);
//    	  Map<String, Objetc> out = simpleJdbcCall.execute(in);
//    	  return (Accidente) out.get("total");
    	  
      
//      public int listcount (String countFecha){    
//  	    String sql="SELECT count(*) FROM accidentes WHERE (fecha BETWEEN '01.01.2020' AND '31.12.2020')";
//  	    return template.update(sql);    
//      
//      }
	    });    
	}    	

	
	
}
