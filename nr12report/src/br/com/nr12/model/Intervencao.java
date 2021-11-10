package br.com.nr12.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="intervencao")
public class Intervencao implements Serializable{
	
	private static final long serialVersionUID = 4753707556038518801L;
	
	@Id
	private int id;
	
	@Column(name="intervencao")
	private String nome;

	private String fotoit01;

	//private List<ImagemPontoPerigo> imagensPontosPerigos;
	
	@ManyToOne
	@JoinColumn(name = "laudoId")
	private Laudo laudo;
	
	public Laudo getLaudo() {
		return laudo;
	}
	public void setLaudo(Laudo laudo) {
		this.laudo = laudo;
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "miparl61intervencao", joinColumns = {
			@JoinColumn(name = "intervencaoId")},
			inverseJoinColumns = { @JoinColumn(name = "miparl61Id")})
	private List<Miparl61> miparl61;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "miparlintervencao", joinColumns = {
			@JoinColumn(name = "intervencaoId")},
			inverseJoinColumns = { @JoinColumn(name = "miparlId")})
	private List<Miparl> miparl;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "riscointervencao", joinColumns = {
			@JoinColumn(name = "intervencaoId")},
			inverseJoinColumns = { @JoinColumn(name = "riscoId")})
	private List<Risco> risco;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "sistemasegurancaintervencao", joinColumns = {
			@JoinColumn(name = "intervencaoId")},
			inverseJoinColumns = { @JoinColumn(name = "sistemasegurancaId")})
	private List<SistemaSeg> sistemaseg;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "sistemaseguranca2intervencao", joinColumns = {
			@JoinColumn(name = "intervencaoId")},
			inverseJoinColumns = { @JoinColumn(name = "sistemaseguranca2Id")})
	private List<SistemaSeg2> sistemaseg2;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "perigointervencao", joinColumns = {
			@JoinColumn(name = "intervencaoId")},
			inverseJoinColumns = { @JoinColumn(name = "perigoId")})
	private List<Perigo> perigo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFotoit01() {
		return fotoit01;
	}
	public void setFotoit01(String fotoit01) {
		this.fotoit01 = fotoit01;
	}
	
	public List<Miparl61> getMiparl61() {
		return miparl61;
	}
	public void setMiparl61(List<Miparl61> miparl61) {
		this.miparl61 = miparl61;
	}
	
	public List<Miparl> getMiparl() {
		return miparl;
	}
	public void setMiparl(List<Miparl> miparl) {
		this.miparl = miparl;
	}
	
	public List<Risco> getRisco() {
		return risco;
	}
	public void setRisco(List<Risco> risco) {
		this.risco = risco;
	}
	
	public List<SistemaSeg> getSistemaSeg() {
		return sistemaseg;
	}
	public void setSistemaSeg(List<SistemaSeg> sistemaseg) {
		this.sistemaseg = sistemaseg;
	}
	
	public List<SistemaSeg2> getSistemaSeg2() {
		return sistemaseg2;
	}
	public void setSistemaSeg2(List<SistemaSeg2> sistemaseg2) {
		this.sistemaseg2 = sistemaseg2;
	}
	
	public List<Perigo> getPerigo() {
		return perigo;
	}
	public void setPerigo(List<Perigo> perigo) {
		this.perigo = perigo;
	}
	
}