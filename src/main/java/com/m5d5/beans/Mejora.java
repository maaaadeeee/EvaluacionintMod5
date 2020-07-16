package com.m5d5.beans;

public class Mejora {

	private int idmejora;
	private String fecha;
	private String motivo;
	private String actividades;
	private String estado;
	private int clienteid;
	
	public Mejora() {
		super();
	}
	
	
	public Mejora(String fecha, String motivo, String actividades, String estado, int clienteid) {
		super ();
		this.fecha = fecha;
		this.motivo = motivo;
		this.actividades = actividades;
		this.estado = estado;
		this.clienteid = clienteid;
	}



	public int getIdmejora() {
		return idmejora;
	}



	public void setIdmejora(int idmejora) {
		this.idmejora = idmejora;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getMotivo() {
		return motivo;
	}



	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}



	public String getActividades() {
		return actividades;
	}



	public void setActividades(String actividades) {
		this.actividades = actividades;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public int getClienteid() {
		return clienteid;
	}



	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}



	@Override
	public String toString() {
		return "Mejora [idmejora=" + idmejora + ", fecha=" + fecha + ", motivo=" + motivo + ", actividades="
				+ actividades + ", estado=" + estado + ", clienteid=" + clienteid + "]";
	}
	
	

}
