package br.com.nr12.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="configuracoes")
public class Configuracoes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String portaria;
	private String dispositivos;
	private String resptecnica;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPortaria() {
		return portaria;
	}
	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}
	public String getDispositivos() {
		return dispositivos;
	}
	public void setDispositivos(String dispositivos) {
		this.dispositivos = dispositivos;
	}
	public String getResptecnica() {
		return resptecnica;
	}
	public void setResptecnica(String resptecnica) {
		this.resptecnica = resptecnica;
	}

	
}