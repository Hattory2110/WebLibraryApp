package hu.unideb.inf.weblib.service.dto;

import java.util.Objects;

public class LoginDTO {

    String email;
    String jelszo;

    public LoginDTO() {
    }

    public LoginDTO(String email, String jelszo) {
        this.email = email;
        this.jelszo = jelszo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(email, loginDTO.email) && Objects.equals(jelszo, loginDTO.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, jelszo);
    }
}
