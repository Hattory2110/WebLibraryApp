package hu.unideb.inf.weblib.data.repositories;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{

    List<BookEntity> findAllByWriter(String writer);
}
