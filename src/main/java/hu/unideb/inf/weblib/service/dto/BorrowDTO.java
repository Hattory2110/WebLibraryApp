package hu.unideb.inf.weblib.service.dto;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.Objects;

public class BorrowDTO {

    private long id;
    private long osz;
    private long lsz;
    private Date borrowdate;
    private Date duedate;

    public BorrowDTO() {
    }

    public BorrowDTO(long id, long osz, long lsz, Date borrowdate, Date duedate) {
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
        BorrowDTO borrowDTO = (BorrowDTO) o;
        return id == borrowDTO.id && osz == borrowDTO.osz && lsz == borrowDTO.lsz && Objects.equals(borrowdate, borrowDTO.borrowdate) && Objects.equals(duedate, borrowDTO.duedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, osz, lsz, borrowdate, duedate);
    }
}
