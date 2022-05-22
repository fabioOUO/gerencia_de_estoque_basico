package DIO.gerenciadeestoque.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "statusCodeNfe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StatusCodeNfe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @NotNull
    private int codigoStatusCode;

    @NotNull
    @Column(length = 200)
    private String descricao;

    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    private LocalDateTime dataCricao = LocalDateTime.now();
}
