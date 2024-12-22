package hu.unideb.inf.weblib.data.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "reader")
public class ReaderEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long osz; //Olvasó szám
    @Column(name = "nev")
    private String nev;
    @Column(name = "szuletesi_datum")
    private Date szuldate;
    @Column(name = "cim")
    private String cim;
    @Column(name = "nem")
    private String nem;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telefonszam")
    private String telefon;
    @Column(name = "jelszo", nullable = false)
    private String jelszo;

    @Enumerated(EnumType.STRING)
    private Authorization jogosultsag;

    public ReaderEntity() {
    }

    public ReaderEntity(long osz, String nev, Date szuldate, String cim, String nem, String email, String telefon, String jelszo) {
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

    public void setOsz(Long osz) {
        this.osz = osz;
    }

    public Authorization getJogosultsag() {
        return jogosultsag;
    }

    public void setJogosultsag(Authorization jogosultsag) {
        this.jogosultsag = jogosultsag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReaderEntity that = (ReaderEntity) o;
        return osz == that.osz && Objects.equals(nev, that.nev) && Objects.equals(szuldate, that.szuldate) && Objects.equals(cim, that.cim) && Objects.equals(nem, that.nem) && Objects.equals(email, that.email) && Objects.equals(telefon, that.telefon) && Objects.equals(jelszo, that.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(osz, nev, szuldate, cim, nem, email, telefon, jelszo);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(jogosultsag.name()));
    }

    @Override
    public String getPassword() {
        return jelszo;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
