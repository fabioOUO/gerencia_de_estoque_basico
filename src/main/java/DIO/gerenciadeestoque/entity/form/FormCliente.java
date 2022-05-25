package DIO.gerenciadeestoque.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormCliente {

    private long codigo;


    @NotEmpty(message = "Preencha o campo nome!")
    private String nome;

    @NotEmpty(message = "Preencha o campo email!")
    private String email;

    private LocalDateTime dataAtualizacao;

    private LocalDateTime dataCricao;

}
