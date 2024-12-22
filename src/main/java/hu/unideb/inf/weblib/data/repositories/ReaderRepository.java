package hu.unideb.inf.weblib.data.repositories;

import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<ReaderEntity, Long>{
}
