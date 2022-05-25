package DIO.gerenciadeestoque.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cfop")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cfop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @NonNull
    private long codigoCfop;

    @NonNull
    @Column(length = 100)
    private String descricao;

    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    private LocalDateTime dataCricao = LocalDateTime.now();
}
