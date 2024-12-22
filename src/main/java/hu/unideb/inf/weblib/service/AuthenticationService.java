package hu.unideb.inf.weblib.service;

import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    public ReaderEntity regisztracio(String email, String password);

    //Contains optional fields
    public ReaderEntity regisztracioOpt(ReaderEntity felhasznalo);

//    public Authentication  bejelentkezes(String email, String password);
    public Authentication bejelentkezes(ReaderEntity felhasznalo);
}
