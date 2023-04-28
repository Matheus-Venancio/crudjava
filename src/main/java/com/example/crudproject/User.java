package com.example.crudproject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		 @Column(nullable = false)
		    private String nome;

		    @Column(nullable = false, unique = true)
		    private String email;

		    @Column(nullable = false, unique = true)
		    private String cpf;

		    @Column(nullable = false)
		    private String telefone;
		
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
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
}
