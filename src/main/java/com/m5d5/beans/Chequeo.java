package com.m5d5.beans;

public class Chequeo {

	private int idchequeo;
	private String detalle;
	private String estado;
	private int visitaid;
	
	public Chequeo(){
		super ();
	}
	
	public Chequeo(String detalle, String estado, int visitaid) {
		super ();
		this.detalle = detalle;
		this.estado = estado;
		this.visitaid = visitaid;
	}



	public int getIdchequeo() {
		return idchequeo;
	}



	public void setIdchequeo(int idchequeo) {
		this.idchequeo = idchequeo;
	}



	public String getDetalle() {
		return detalle;
	}



	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public int getVisitaid() {
		return visitaid;
	}



	public void setVisitaid(int visitaid) {
		this.visitaid = visitaid;
	}



	@Override
	public String toString() {
		return "Chequeo [idchequeo=" + idchequeo + ", detalle=" + detalle + ", estado=" + estado + ", visitaid="
				+ visitaid + "]";
	}
	
	

}
