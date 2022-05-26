package DIO.gerenciadeestoque.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormCst {
    private long codigo;

    @NotNull
    private int origem;

    @NotNull
    private int icms;

    @NotNull
    private int ipi;

    @NotNull
    private int pis;

    @NotNull
    private int cofins;

    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataCricao;
}
