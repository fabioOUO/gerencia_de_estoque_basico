package DIO.gerenciadeestoque.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "estoque")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private long quantidade;

    @OneToOne
    @JoinColumn(name = "produtoCodigo", unique = true)
    private Produto produto;

    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    private LocalDateTime dataCricao = LocalDateTime.now();
}
