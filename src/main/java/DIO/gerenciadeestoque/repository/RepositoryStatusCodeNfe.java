package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.StatusCodeNfe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryStatusCodeNfe extends JpaRepository<StatusCodeNfe, Long> {
    
}
