package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEstoque extends JpaRepository<Estoque, Long> {
}
