package hu.unideb.inf.weblib.data.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "borrow")
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "borrowdate", nullable = false)
    private Date borrowdate;
    @Column(name = "duedate", nullable = false)
    private Date duedate;

    @OneToMany(cascade = CascadeType.ALL) //Egy kölcsönzés alatt lehet több könyv, de a könyv leltári száma egyedi
    @JoinTable(name = "bookborrow",
            joinColumns = {@JoinColumn(name = "borrow_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "lsz")}
    )
    private List<BookEntity> bookEntities;

    @ManyToOne(cascade = CascadeType.ALL) // Egy olvasónak több lejáratú kölcsönzései lehetnek
    @JoinColumn(name = "reader_id", referencedColumnName = "osz")
    private ReaderEntity reader;

    public BorrowEntity() {
    }

    public BorrowEntity(long id, Date borrowdate, Date duedate) {
        this.id = id;
        this.borrowdate = borrowdate;
        this.duedate = duedate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowEntity that = (BorrowEntity) o;
        return id == that.id && Objects.equals(borrowdate, that.borrowdate) && Objects.equals(duedate, that.duedate) && Objects.equals(bookEntities, that.bookEntities) && Objects.equals(reader, that.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrowdate, duedate, bookEntities, reader);
    }
}
