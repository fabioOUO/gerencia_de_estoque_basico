package DIO.gerenciadeestoque.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormStatusCodeNfe {

    private long codigo;

    private int codigoStatusCode;

    @NotEmpty(message = "Preencha o campo descrição!")
    private String descricao;

    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataCricao;
}
