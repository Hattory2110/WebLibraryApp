package hu.unideb.inf.weblib.service.dto;

import java.util.Date;
import java.util.Objects;
public class BookDTO {

    private long lsz; //Leltári szám
    private String title;
    private String genre;
    private String writer;
    private String pubisher;

    public BookDTO() {
    }

    public BookDTO(long lsz, String title, String genre, String writer, String pubisher, Integer releaseYear) {
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
        BookDTO bookDTO = (BookDTO) o;
        return lsz == bookDTO.lsz && Objects.equals(title, bookDTO.title) && Objects.equals(genre, bookDTO.genre) && Objects.equals(writer, bookDTO.writer) && Objects.equals(pubisher, bookDTO.pubisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lsz, title, genre, writer, pubisher);
    }
}
