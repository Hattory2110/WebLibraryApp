package hu.unideb.inf.weblib.service.dto;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.Objects;
public class ReaderDTO {

    private long osz; //Olvasó szám
    private String nev;
    private Date szuldate;
    private String cim;
    private String nem;
    private String email;
    private String telefon;
    private String jelszo;

    public ReaderDTO() {
    }

    public ReaderDTO(long osz, String nev, Date szuldate, String cim, String nem, String email, String telefon, String jelszo) {
        this.osz = osz;
        this.nev = nev;
        this.szuldate = szuldate;
        this.cim = cim;
        this.nem = nem;
        this.email = email;
        this.telefon = telefon;
        this.jelszo = jelszo;
    }

    public long getOsz() {
        return osz;
    }

    public void setOsz(long osz) {
        this.osz = osz;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzuldate() {
        return szuldate;
    }

    public void setSzuldate(Date szuldate) {
        this.szuldate = szuldate;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReaderDTO readerDTO = (ReaderDTO) o;
        return osz == readerDTO.osz && Objects.equals(nev, readerDTO.nev) && Objects.equals(szuldate, readerDTO.szuldate) && Objects.equals(cim, readerDTO.cim) && Objects.equals(nem, readerDTO.nem) && Objects.equals(email, readerDTO.email) && Objects.equals(telefon, readerDTO.telefon) && Objects.equals(jelszo, readerDTO.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(osz, nev, szuldate, cim, nem, email, telefon, jelszo);
    }
}
