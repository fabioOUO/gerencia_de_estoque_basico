package DIO.gerenciadeestoque.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstoqueForm {

    private long codigo;

    @Positive
    private long quantidade;

    @NonNull
    private long produtoCodigo;

    private LocalDateTime dataAtualizacao;

    private LocalDateTime dataCricao;
}
