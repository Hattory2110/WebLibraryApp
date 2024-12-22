package hu.unideb.inf.weblib.data.entities;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.Date;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lsz; //Leltári szám
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "genre", nullable = false)
    private String genre;
    @Column(name = "writer", nullable = false)
    private String writer;
    @Column(name = "pubisher", nullable = false)
    private String pubisher;

    public BookEntity() {
    }

    public BookEntity(long lsz, String title, String genre, String writer, String pubisher, Integer releaseYear) {
        this.lsz = lsz;
        this.title = title;
        this.genre = genre;
        this.writer = writer;
        this.pubisher = pubisher;
    }

    public long getLsz() {
        return lsz;
    }

    public void setLsz(long lsz) {
        this.lsz = lsz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPubisher() {
        return pubisher;
    }

    public void setPubisher(String pubisher) {
        this.pubisher = pubisher;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return lsz == that.lsz && Objects.equals(title, that.title) && Objects.equals(genre, that.genre) && Objects.equals(writer, that.writer) && Objects.equals(pubisher, that.pubisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lsz, title, genre, writer, pubisher);
    }
}
