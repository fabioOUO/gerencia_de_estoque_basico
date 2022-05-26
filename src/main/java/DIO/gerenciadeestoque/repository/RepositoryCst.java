package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.Cst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCst extends JpaRepository<Cst, Long> {
}
