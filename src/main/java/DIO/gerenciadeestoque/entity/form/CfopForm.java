package DIO.gerenciadeestoque.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CfopForm {
    private long codigo;

    @NonNull
    private long codigoCfop;

    @NonNull
    private String descricao;

    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataCricao;
}
