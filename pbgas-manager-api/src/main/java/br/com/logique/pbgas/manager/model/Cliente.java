package br.com.logique.pbgas.manager.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String razaoSocial;

	private String nomeFantasia;

	@Embedded
	private Estacao estacao;

	@Embedded
	private Medidor medidor;

	private Long areaId;

	private Boolean usaCorrecaoCv;

	private Boolean ativo;

	
	public Cliente() {
		
	}
	public  Cliente(Cliente c) {
		this.id = c.id;
		this.razaoSocial = c.razaoSocial;
		this.nomeFantasia = c.nomeFantasia;
		this.estacao = c.estacao;
		this.medidor = c.medidor;
		this.areaId = c.areaId;
		this.usaCorrecaoCv = c.usaCorrecaoCv;
		this.ativo = c.ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Estacao getEstacao() {
		return estacao;
	}

	public void setEstacao(Estacao estacao) {
		this.estacao = estacao;
	}

	public Medidor getMedidor() {
		return medidor;
	}

	public void setMedidor(Medidor medidor) {
		this.medidor = medidor;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Boolean getUsaCorrecaoCv() {
		return usaCorrecaoCv;
	}

	public void setUsaCorrecaoCv(Boolean usaCorrecaoCv) {
		this.usaCorrecaoCv = usaCorrecaoCv;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
	
	
	
}
