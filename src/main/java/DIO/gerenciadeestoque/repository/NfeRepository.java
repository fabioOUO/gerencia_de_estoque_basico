package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.Nfe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NfeRepository extends JpaRepository<Nfe, Long> {
}