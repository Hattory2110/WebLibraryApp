package hu.unideb.inf.weblib.data.repositories;

import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Reader;
import java.util.List;

@Repository
public interface ReaderRepository extends JpaRepository<ReaderEntity, Long>{

    ReaderEntity findByEmail(String email);

    List<ReaderEntity> findAllByNevOrderBySzuldate(String nev);
}
