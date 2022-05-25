package DIO.gerenciadeestoque.entity.form;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormNfe {

    private long codigo;


    @NotEmpty(message = "Preencha o campo chave!")
    private String chave;

    @NotNull
    private long statusCodeNfeCodigo;

    @NotNull
    private long clienteCodigo;

    @NotNull
    private long produtoCodigo;

    @NotNull
    @Positive
    private long quantidade;

    @NotNull
    @Positive
    private double valorTotal;

    private LocalDateTime dataEmissao;

}
