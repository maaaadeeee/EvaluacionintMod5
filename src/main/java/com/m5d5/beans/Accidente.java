package com.m5d5.beans;

public class Accidente {

	private int idaccidente;
	private String fecha;
	private String hora;
	private String suceso;
	private String lugar;
	private int clienteid;
	
	
	
public Accidente() {
		super();
	}
	
	public Accidente(String fecha, String hora, String suceso, String lugar, int clienteid) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.suceso = suceso;
		this.lugar = lugar;
		this.clienteid = clienteid;
	}


	public int getIdaccidente() {
		return idaccidente;
	}


	public void setIdaccidente(int idaccidente) {
		this.idaccidente = idaccidente;
	}


	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public String getHora() {
		return hora;
	}




	public void setHora(String hora) {
		this.hora = hora;
	}




	public String getSuceso() {
		return suceso;
	}




	public void setSuceso(String suceso) {
		this.suceso = suceso;
	}




	public String getLugar() {
		return lugar;
	}




	public void setLugar(String lugar) {
		this.lugar = lugar;
	}




	public int getClienteid() {
		return clienteid;
	}



	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}
	@Override
	public String toString() {
		return "Accidente [idaccidente=" + idaccidente + ", fecha=" + fecha + ", hora=" + hora + ", suceso=" + suceso
				+ ", lugar=" + lugar + ", clienteid=" + clienteid + "]";
	}

}
