package hu.unideb.inf.weblib.data.repositories;

import hu.unideb.inf.weblib.data.entities.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, Long>{
}
