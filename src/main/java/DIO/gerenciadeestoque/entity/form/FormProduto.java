package DIO.gerenciadeestoque.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormProduto {

    private long codigo;

    @NotEmpty(message = "Preencha o campo descrição!")
    private String descricao;

    @NonNull
    @Positive
    @NumberFormat
    private double valorUnitario;

    @Positive
    @NumberFormat
    private double pesoBruto;

    @Positive
    @NumberFormat
    private double pesoLiquido;

    @NonNull
    private long ncmCodigo;

    @NonNull
    private long produtoCodigo;

    private LocalDateTime dataAtualizacao;

    private LocalDateTime dataCricao;
}
