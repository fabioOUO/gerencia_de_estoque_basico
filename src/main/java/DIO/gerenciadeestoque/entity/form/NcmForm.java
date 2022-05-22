package DIO.gerenciadeestoque.entity.form;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NcmForm {

    private long codigo;

    @NotEmpty(message = "Preencha o campo descrição!")
    private String descricao;

    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataCricao;

}
