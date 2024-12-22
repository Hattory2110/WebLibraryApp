package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    public String regisztracio(String email, String password);

    //Contains optional fields
    public String regisztracioOpt(ReaderDTO felhasznalo);

//    public Authentication  bejelentkezes(String email, String password);
    public String bejelentkezes(ReaderDTO felhasznalo);
}
