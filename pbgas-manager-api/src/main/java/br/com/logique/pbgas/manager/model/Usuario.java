package br.com.logique.pbgas.manager.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.jetbrains.annotations.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * 
 * @author Tamires
 * 
 * classe usuário da aplicação
 *
 *atributos:id, nome, email, login,senha,perfil,codigoResetSenha, dataExpiracaoSenha
 *
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    private String nome;

	    @Email
	    @Size(min = 6, max = 254)
	    @Column(length = 254, unique = true)
	    private String email;
	    @NotNull
	    @Column(length = 20, unique = true)
	    private String login;

	    @NotNull
	    @Size(min = 6, max = 60)
	    @Column(length = 60, nullable = false)
	    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	    private String senha;

	    @NotNull
	    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "perfil_usuario",
	            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "perfil_id", referencedColumnName = "id")
	    )
	    
	    private Perfil perfil;

	    @JsonIgnore
	    private String codigoResetSenha;

	    @JsonIgnore
	    private LocalDateTime dataExpiracaoResetSenha;
	    
	    
	    //constructors
	    public Usuario(Usuario u) {
	    	this.id = u.id;
			this.login = u.login;
			this.senha = u.senha;
			this.perfil=u.perfil;
	    }

	    public Usuario() {
			// TODO Auto-generated constructor stub
		}
	    
	    // getters e setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public Perfil getPerfil() {
			return perfil;
		}

		public void setPerfil(Perfil perfil) {
			this.perfil = perfil;
		}

		public String getCodigoResetSenha() {
			return codigoResetSenha;
		}

		public void setCodigoResetSenha(String codigoResetSenha) {
			this.codigoResetSenha = codigoResetSenha;
		}

		public LocalDateTime getDataExpiracaoResetSenha() {
			return dataExpiracaoResetSenha;
		}

		public void setDataExpiracaoResetSenha(LocalDateTime dataExpiracaoResetSenha) {
			this.dataExpiracaoResetSenha = dataExpiracaoResetSenha;
		}

		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha
					+ ", perfil=" + perfil + ", codigoResetSenha=" + codigoResetSenha + ", dataExpiracaoResetSenha="
					+ dataExpiracaoResetSenha + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(codigoResetSenha, dataExpiracaoResetSenha, email, id, login, nome, perfil, senha);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			return Objects.equals(codigoResetSenha, other.codigoResetSenha)
					&& Objects.equals(dataExpiracaoResetSenha, other.dataExpiracaoResetSenha)
					&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
					&& Objects.equals(login, other.login) && Objects.equals(nome, other.nome)
					&& Objects.equals(perfil, other.perfil) && Objects.equals(senha, other.senha);
		}
	    
	    
	    
}
