package br.com.nr12.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resposta")
public class Resposta implements Serializable{
	
	private static final long serialVersionUID = -8216459208187096476L;
	
	@Id
	private int id;
	private String resposta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}