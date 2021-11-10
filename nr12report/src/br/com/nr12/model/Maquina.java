package br.com.nr12.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="maquina")
public class Maquina{
	
	@Id
	private int id;
	
	private String nome;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="clienteId")
	private Cliente cliente;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="tipomaquinaId")
	private TipoMaquina tipoMaquina;
	
	private String modelo;
	private String numeroSerie;
	private String numeroPatrimonio;
	private String capacidade;
	
	@Column(nullable=true, name="ano")
	private Integer ano;
	
	private String fabricante;
	private String setor;
	private String fotofront;
	private String fotole;
	private String fotold;
	private String fotopost;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoMaquina getTipoMaquina() {
		return tipoMaquina;
	}

	public void setTipoMaquina(TipoMaquina tipoMaquina) {
		this.tipoMaquina = tipoMaquina;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getNumeroPatrimonio() {
		return numeroPatrimonio;
	}

	public void setNumeroPatrimonio(String numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getFotofront() {
		return fotofront;
	}

	public void setFotofront(String fotofront) {
		this.fotofront = fotofront;
	}

	public String getFotole() {
		return fotole;
	}

	public void setFotole(String fotole) {
		this.fotole = fotole;
	}

	public String getFotold() {
		return fotold;
	}

	public void setFotold(String fotold) {
		this.fotold = fotold;
	}

	public String getFotopost() {
		return fotopost;
	}

	public void setFotopost(String fotopost) {
		this.fotopost = fotopost;
	}

	public int compareTo(Maquina arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Maquina clone(){
		Maquina m = new Maquina();
		m.setId(this.id);
		m.setNome(this.nome);
		return m;
	}
}
