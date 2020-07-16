package com.m5d5.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.m5d5.beans.Asesoria;    

public class AsesoriaDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Asesoria ase){    
	    String sql="insert into Asesorias (detalle,gestion,propuestas,fecha,especial,clienteid) values ('" + ase.getDetalle() + "','" + ase.getGestion() 
		+ "','" + ase.getPropuestas() + "','" + ase.getFecha() +  "','" + ase.getEspecial() +  "','" + ase.getClienteid() +  "')";
	    return template.update(sql);
	}
	
	public int update(Asesoria ase){    
	    String sql="UPDATE Asesorias SET Detalle = '" + ase.getDetalle() + "', gestion = '" + ase.getGestion() + "', propuestas = '" + ase.getPropuestas() + "', fecha = '" + ase.getFecha()  + "', especial = '" + ase.getEspecial()  +  "', clienteid = '" + ase.getClienteid()  +"' WHERE idasesoria = '" + ase.getIdasesoria() + "'";
	    return template.update(sql);    
	}   
	
	public int delete(int id){    
	    String sql="DELETE FROM Asesorias WHERE idasesoria = "+id+"";
	    return template.update(sql);
	}    

	public Asesoria getAseById(int idasesoria){    
	    String sql="select * from Asesorias where idasesoria=?";
	    return template.queryForObject(sql, new Object[]{idasesoria},new BeanPropertyRowMapper<Asesoria>(Asesoria.class));    
	}    
	
	public List<Asesoria> getAsesoria(){    
	    return template.query("select * from Asesorias",new RowMapper<Asesoria>(){    
	        public Asesoria mapRow(ResultSet rs, int row) throws SQLException {    
	            Asesoria ase=new Asesoria();
	            ase.setIdasesoria(rs.getInt(1));
				ase.setDetalle(rs.getString(2));
				ase.setGestion(rs.getString(3));
				ase.setPropuestas(rs.getString(4));
				ase.setFecha(rs.getString(5));
				ase.setEspecial(rs.getString(6));
				ase.setClienteid(rs.getInt(7));
	            return ase;
	        }    
	    });    
	}    	
	
	
}



