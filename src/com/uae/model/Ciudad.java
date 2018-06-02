package com.uae.model;

public class Ciudad {
	

	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Integer idCiudad;
	private String nombre;
	private String pais;
	private String Cont;
	
	public Ciudad(Integer idCiudad, String nombre, String pais, String cont) {
		super();
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.pais = pais;
		Cont = cont;
	}
	
	public Integer getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCont() {
		return Cont;
	}
	public void setCont(String cont) {
		Cont = cont;
	}
	
	
	
	

}
