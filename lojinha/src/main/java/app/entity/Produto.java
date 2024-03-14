package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Anotation para gerar automaticamente um novo id a cada implementação
	private long id;
	@NotBlank(message = "Campo nome deve ser preenchido")
	private String nome;
	@NotNull
	private Double valor;
    @NotBlank(message = "Campo categoria deve ser preenchido")
    private String categoria;
    
}
