package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.InforTrib;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInforTrib extends JpaRepository<InforTrib, Long> {
}
