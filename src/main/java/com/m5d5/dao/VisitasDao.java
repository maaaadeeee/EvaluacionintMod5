package com.m5d5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.m5d5.beans.Visitas;


public class VisitasDao {

	public class AsesoriaDao {

		JdbcTemplate template;
		
		public void setTemplate(JdbcTemplate template) {    
		    this.template = template;    
		}
		
		public int save(Visitas vis){    
		    String sql="insert into Visitas (direccion,ciudad,fecha,resumen,observaciones,cliente_id,empleado_idempleado) values ('" + vis.getDireccion() + "','" + vis.getCiudad() 
			+ "','" + vis.getFecha() + "','" + vis.getResumen() +  "','" + vis.getObservaciones() +  "','" + vis.getClienteid() + "','" + vis.getEmpleadoid() + "')";
		    return template.update(sql);
		}
		
		public int update(Visitas vis){    
		    String sql="UPDATE Visitas SET Direccion = '" + vis.getDireccion() + "', ciudad = '" + vis.getCiudad() + "', fecha = '" + vis.getFecha() + "', resumen = '" + vis.getResumen()  + "', observaciones = '" + vis.getObservaciones()  +  "', clienteid = '" + vis.getClienteid()  +"' WHERE idvisita = '" + vis.getIdvisita() + "'";
		    return template.update(sql);    
		}   
		
		public int delete(int id){    
		    String sql="DELETE FROM Visitas WHERE idvisita = "+id+"";
		    return template.update(sql);
		}    

		public Visitas getVisById(int idvisita){    
		    String sql="select * from Asesorias where idvisita=?";
		    return template.queryForObject(sql, new Object[]{idvisita},new BeanPropertyRowMapper<Visitas>(Visitas.class));    
		}    
		
		public List<Visitas> getVisitas(){    
		    return template.query("select * from Visitas",new RowMapper<Visitas>(){    
		        public Visitas mapRow(ResultSet rs, int row) throws SQLException {    
		            Visitas vis=new Visitas();
		            vis.setIdvisita(rs.getInt(1));
					vis.setDireccion(rs.getString(2));
					vis.setCiudad(rs.getString(3));
					vis.setFecha(rs.getString(4));
					vis.setResumen(rs.getString(5));
					vis.setObservaciones(rs.getString(6));
					vis.setClienteid(rs.getInt(7));
					vis.setEmpleadoid(rs.getInt(8));
		            return vis;
		        }    
		    });    
		}    	
		
		
	}



