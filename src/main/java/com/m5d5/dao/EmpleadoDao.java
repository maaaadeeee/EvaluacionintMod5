package com.m5d5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.m5d5.beans.Empleado;

public class EmpleadoDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	public int saveemp(Empleado emp){    
	    String sql="insert into Empleado (nombre,especialidad) values ('" + emp.getNombre() + "','" + emp.getEspecialidad() + "')";
	    return template.update(sql);
	}
	
	public int updateemp(Empleado emp){    
	    String sql="update Empleado set nombre = '" +emp.getNombre() + "', especialidad = '" + emp.getEspecialidad() + "' where idempleado = '" + emp.getIdempleado() + "'";
	    return template.update(sql);    
	}   
	
	public int deleteemp(int idempleado){    
	    String sql="delete from Empleado where idempleado = " + idempleado + "";
	    return template.update(sql);
	}             

	public Empleado getEmpById(int idempleado){    
	    String sql="select * from Empleado WHERE idempleado = ?";
	    return template.queryForObject(sql, new Object[]{idempleado},new BeanPropertyRowMapper<Empleado>(Empleado.class));    
	}
	
	public List<Empleado> getEmpleado(){    
	    return template.query("select * from Empleado",new RowMapper<Empleado>(){    
	        public Empleado mapRow(ResultSet rs, int row) throws SQLException {    
	            Empleado emp=new Empleado();    
	            emp.setIdempleado(rs.getInt(1));    
	            emp.setNombre(rs.getString(2));    
	            emp.setEspecialidad(rs.getString(3));
	            return emp;
	        }    
	    });    
	}    	
	
	
	
}
