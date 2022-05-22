package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.StatusCodeNfe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusCodeNfeRepository extends JpaRepository<StatusCodeNfe, Long> {
    
}
