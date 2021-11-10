package br.com.nr12.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="normaregulamentadora")
public class NormaRegulamentadora implements Serializable{
		
	private static final long serialVersionUID = -7769966151492615851L;
	
	@Id
	private int id;
	private String item;
	private String norma;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getNorma() {
		return norma;
	}
	public void setNorma(String norma) {
		this.norma = norma;
	}
}