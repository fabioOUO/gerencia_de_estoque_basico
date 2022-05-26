package DIO.gerenciadeestoque.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormInforTrib {
    private long codigo;

    @NonNull
    private long cstCodigo;

    @NonNull
    private long cfopCodigo;

    private LocalDateTime dataAtualizacao;

    private LocalDateTime dataCricao;

}
