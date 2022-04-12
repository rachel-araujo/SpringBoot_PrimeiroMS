package br.com.nava.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="USUARIOS")
@Entity
public class UsuarioEntity  {
	
	@Id
	//dizer como sera gerada a chave primaria =>
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//nome_usuario
	@Column(name = "nome")
	private String nome;
	private String email;
	
	
	
	//SELECT * FROM USUARIOS U INNER JOIN ENDERECOS E ON U.ID = E.ID
   //JOIN COLUMN é entidade mais "FORTE" ( a que possui o campo com a chave estrangeira)
	@OneToOne
	//diz o nome da coluna que é a chave estrangeira:
	@JoinColumn(name = "endereco_id")
	private EnderecoEntity endereco;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<VendaEntity> vendas;



//	@Override
//	public String toString() {
//		return "UsuarioEntity [id=" + id + ", nome=" + nome + ", email=" + email + "]";
//	}

	
	
	}
	
	
	


