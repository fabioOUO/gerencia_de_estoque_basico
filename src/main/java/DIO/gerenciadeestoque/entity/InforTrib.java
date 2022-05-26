package DIO.gerenciadeestoque.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inforTrib")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class InforTrib {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @OneToOne
    @JoinColumn(name = "cstCodigo")
    private Cst cst;

    @OneToOne
    @JoinColumn(name = "cfopCodigo")
    private Cfop cfop;

    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    private LocalDateTime dataCricao = LocalDateTime.now();

}
