package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
}
