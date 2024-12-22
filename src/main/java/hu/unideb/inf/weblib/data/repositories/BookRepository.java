package hu.unideb.inf.weblib.data.repositories;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{
}
