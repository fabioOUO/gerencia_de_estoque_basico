package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.Cfop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCfop extends JpaRepository<Cfop, Long> {
}
