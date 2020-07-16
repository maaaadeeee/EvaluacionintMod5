package com.m5d5.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.m5d5.beans.Cliente;    

public class ClienteDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Cliente cli){    
	    String sql="insert into Cliente (nombre,telefono,correoelectronico,rubro,direccion) values('"+cli.getNombre()+"',"+cli.getTelefono()+",'"+cli.getCorreoelectronico()+"','"+cli.getRubro()+"','"+cli.getDireccion()+"')";
	    return template.update(sql);
	}
	
	public int update(Cliente cli){    
	    String sql="update Cliente set nombre='"+cli.getNombre()+"', telefono='"+cli.getTelefono()+"',correoelectronico='"+cli.getCorreoelectronico()+"', rubro='"+cli.getRubro()+"', direccion='"+cli.getDireccion()+"' where id='"+cli.getId()+"'";
	    return template.update(sql);    
	}   
	
	public int deletecli(int id){    
	    String sql="delete from Cliente where id="+id+"";
	    return template.update(sql);
	}    

	public Cliente getCliById(int id){    
	    String sql="select * from Cliente where id=?";
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Cliente>(Cliente.class));    
	}
	
	public List<Cliente> getClientes(){    
	    return template.query("select * from Cliente",new RowMapper<Cliente>(){    
	        public Cliente mapRow(ResultSet rs, int row) throws SQLException {    
	            Cliente cli=new Cliente();    
	            cli.setId(rs.getInt(1));    
	            cli.setNombre(rs.getString(2));    
	            cli.setTelefono(rs.getInt(3));
	            cli.setCorreoelectronico(rs.getString(4));
	            cli.setRubro(rs.getString(5));
	            cli.setDireccion(rs.getString(6));
	            return cli;
	        }    
	    });    
	}    	
	
	
}
