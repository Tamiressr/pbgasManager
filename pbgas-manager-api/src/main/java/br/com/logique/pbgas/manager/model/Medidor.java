package br.com.logique.pbgas.manager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Medidor {
	@Column(name = "codigo_medidor_scada_flex")
    private Double codigo;

    @Column(name = "nome_medidor_scada_flex")
    private String nome;

    public Medidor() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    
	public Double getCodigo() {
		return codigo;
	}

	public void setCodigo(Double codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
    
    
}
