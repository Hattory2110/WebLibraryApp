package hu.unideb.inf.weblib.service.impl;

import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import hu.unideb.inf.weblib.data.repositories.ReaderRepository;
import hu.unideb.inf.weblib.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ReaderEntity regisztracio(String email, String password) {
        ReaderEntity felhasznalo = new ReaderEntity();
        felhasznalo.setEmail(email);
        felhasznalo.setJelszo(passwordEncoder.encode(password));

        return readerRepository.save(felhasznalo);
    }

    @Override
    public ReaderEntity regisztracioOpt(ReaderEntity felhasznalo) {
        felhasznalo.setJelszo(passwordEncoder.encode(felhasznalo.getJelszo()));
        return readerRepository.save(felhasznalo);
    }

    @Override
    public Authentication bejelentkezes(ReaderEntity felhasznalo) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(felhasznalo.getUsername(),
                        felhasznalo.getPassword())
        );
    }


}
