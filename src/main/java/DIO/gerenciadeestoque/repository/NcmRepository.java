package DIO.gerenciadeestoque.repository;

import DIO.gerenciadeestoque.entity.Ncm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NcmRepository extends JpaRepository<Ncm, Long> {
}
