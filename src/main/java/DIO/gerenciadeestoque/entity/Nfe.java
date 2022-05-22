package DIO.gerenciadeestoque.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nfe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Nfe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @NonNull
    @Column(length = 44, unique = true)
    private String chave;

    private long quantidade;

    @OneToOne
    @JoinColumn(name = "clienteCodigo")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "produtoCodigo")
    private Produto produto;

    private double valorTotal;

    private LocalDateTime dataEmissao = LocalDateTime.now();
}
