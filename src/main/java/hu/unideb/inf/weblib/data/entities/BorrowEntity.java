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
    @Column(name = "Osz")
    private long osz;
    @Column(name = "Lsz")
    private long lsz;
    @Column(name = "borrowdate")
    private Date borrowdate;
    @Column(name = "duedate")
    private Date duedate;

    @OneToMany(cascade = CascadeType.ALL) //Egy kölcsönzés alatt lehet több könyv, de a könyv leltári száma egyedi
    @JoinTable(name = "bookborrow",
            joinColumns = {@JoinColumn(name = "borrow_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "LSz")}
    )
    private List<BookEntity> bookEntities;

    @ManyToOne(cascade = CascadeType.ALL) // Egy olvasónak több lejáratú kölcsönzései lehetnek
    @JoinColumn(name = "reader_id", referencedColumnName = "osz")
    private ReaderEntity reader;

    public BorrowEntity() {
    }

    public BorrowEntity(long id, long osz, long lsz, Date borrowdate, Date duedate) {
        this.id = id;
        this.osz = osz;
        this.lsz = lsz;
        this.borrowdate = borrowdate;
        this.duedate = duedate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOsz() {
        return osz;
    }

    public void setOsz(long osz) {
        this.osz = osz;
    }

    public long getLsz() {
        return lsz;
    }

    public void setLsz(long lsz) {
        this.lsz = lsz;
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
        return id == that.id && osz == that.osz && lsz == that.lsz && Objects.equals(borrowdate, that.borrowdate) && Objects.equals(duedate, that.duedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, osz, lsz, borrowdate, duedate);
    }
}
