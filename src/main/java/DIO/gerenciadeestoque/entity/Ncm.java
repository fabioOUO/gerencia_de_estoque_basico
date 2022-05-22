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
@Table(name = "ncm")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ncm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(length = 100)
    private String descricao;

    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    private LocalDateTime dataCricao = LocalDateTime.now();
}
