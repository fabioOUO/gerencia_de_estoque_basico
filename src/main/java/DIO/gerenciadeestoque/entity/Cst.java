package DIO.gerenciadeestoque.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cst")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
