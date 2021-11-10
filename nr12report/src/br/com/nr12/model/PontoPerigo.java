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
@Table(name="pontoperigo")
public class PontoPerigo implements Serializable{
	
	private static final long serialVersionUID = 4753707556038518801L;
	
	@Id
	private int id;
	
	@Column(name="pontoPerigo")
	private String nome;
	
	private String face;
	
	private String anexo1;
	private String nbr14153;
	private String severidade;
	private String frequencia;
	private String possibilidade;
	private int pe;
	private int fe;
	private int pmp;
	private int np;
	private String fotopp01;
	private float nivelRisco;
	private String analiseProtecao;
	private String indicacaoSolucao;
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
	
	@ManyToOne
	@JoinColumn(name = "sistemasegurancaId")
	private SistemaSeg sistemaseg;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "riscopontoperigo", joinColumns = {
			@JoinColumn(name = "pontoperigoId")},
			inverseJoinColumns = { @JoinColumn(name = "riscoId")})
	private List<Risco> riscos;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "perigopontoperigo", joinColumns = {
			@JoinColumn(name = "pontoperigoId")},
			inverseJoinColumns = { @JoinColumn(name = "perigoId")})
	private List<Perigo> perigos;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "normapontoperigo", joinColumns = {
			@JoinColumn(name = "pontoperigoId")},
			inverseJoinColumns = { @JoinColumn(name = "normaId")})
	private List<NormaRegulamentadora> normasRegulamentadoras;
	
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
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getAnexo1() {
		return anexo1;
	}
	public void setAnexo1(String anexo1) {
		this.anexo1 = anexo1;
	}
	public String getNbr14153() {
		return nbr14153;
	}
	public void setNbr14153(String nbr14153) {
		this.nbr14153 = nbr14153;
	}
	public String getSeveridade() {
		return severidade;
	}
	public void setSeveridade(String severidade) {
		this.severidade = severidade;
	}
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	public String getPossibilidade() {
		return possibilidade;
	}
	public void setPossibilidade(String possibilidade) {
		this.possibilidade = possibilidade;
	}
	public int getPe() {
		return pe;
	}
	public void setPe(int pe) {
		this.pe = pe;
	}
	public int getFe() {
		return fe;
	}
	public void setFe(int fe) {
		this.fe = fe;
	}
	public int getPmp() {
		return pmp;
	}
	public void setPmp(int pmp) {
		this.pmp = pmp;
	}
	public int getNp() {
		return np;
	}
	public void setNp(int np) {
		this.np = np;
	}
	public String getFotopp01() {
		return fotopp01;
	}
	public void setFotopp01(String fotopp01) {
		this.fotopp01 = fotopp01;
	}
	public float getNivelRisco() {
		return nivelRisco;
	}
	public void setNivelRisco(float nivelRisco) {
		this.nivelRisco = nivelRisco;
	}
	public String getAnaliseProtecao() {
		return analiseProtecao;
	}
	public void setAnaliseProtecao(String analiseProtecao) {
		this.analiseProtecao = analiseProtecao;
	}
	public String getIndicacaoSolucao() {
		return indicacaoSolucao;
	}
	public void setIndicacaoSolucao(String indicacaoSolucao) {
		this.indicacaoSolucao = indicacaoSolucao;
	}
	public List<Risco> getRiscos() {
		return riscos;
	}
	public void setRiscos(List<Risco> riscos) {
		this.riscos = riscos;
	}
	public List<Perigo> getPerigos() {
		return perigos;
	}
	public void setPerigos(List<Perigo> perigos) {
		this.perigos = perigos;
	}
	public List<NormaRegulamentadora> getNormasRegulamentadoras() {
		return normasRegulamentadoras;
	}
	public void setNormasRegulamentadoras(List<NormaRegulamentadora> normasRegulamentadoras) {
		this.normasRegulamentadoras = normasRegulamentadoras;
	}
	public SistemaSeg getSistemaSeg() {
		return sistemaseg;
	}
	public void setSistemaSeguranca(SistemaSeg sistemaseg) {
		this.sistemaseg = sistemaseg;
	}
	
}