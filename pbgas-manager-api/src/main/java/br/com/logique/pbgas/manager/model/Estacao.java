package br.com.logique.pbgas.manager.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Estacao {
	    @Column(name = "codigo_estacao_scada_flex")
	    private Double codigo;

	    @Column(name = "nome_estacao_scada_flex")
	    private String nome;

	    
	    
	    
	    
	    public Estacao() {
			// TODO Auto-generated constructor stub
		}
	    
		public Estacao(Double codigo, String nome) {
			super();
			this.codigo = codigo;
			this.nome = nome;
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
