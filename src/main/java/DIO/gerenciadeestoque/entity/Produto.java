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
@Table(name = "produto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(length = 100)
    private String descricao;

    @OneToOne
    @JoinColumn(name = "ncmCodigo")
    private Ncm NCM;

    private double valor;

    private double pesoBruto;

    private double pesoLiquido;

    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    private LocalDateTime dataCricao = LocalDateTime.now();

}