package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    public ReaderDTO regisztracio(String email, String password);

    //Contains optional fields
    public ReaderDTO regisztracioOpt(ReaderDTO felhasznalo);

//    public Authentication  bejelentkezes(String email, String password);
    public Authentication bejelentkezes(ReaderDTO felhasznalo);
}
