package hu.unideb.inf.weblib.data.repositories;

import hu.unideb.inf.weblib.data.entities.BookEntity;
import hu.unideb.inf.weblib.data.entities.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, Long>{

    List<BorrowEntity> findByBookEntitiesContains(BookEntity bookEntity);
}
