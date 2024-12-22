package hu.unideb.inf.weblib.service.impl;

import hu.unideb.inf.weblib.data.entities.Authorization;
import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import hu.unideb.inf.weblib.data.repositories.ReaderRepository;
import hu.unideb.inf.weblib.service.AuthenticationService;
import hu.unideb.inf.weblib.service.JwtService;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String regisztracio(String email, String password) {
        ReaderEntity entity = new ReaderEntity();
        entity.setJelszo(password);
        entity.setEmail(email);
        entity.setJogosultsag(Authorization.USER);

        entity = readerRepository.save(entity);
        return jwtService.generateToken(entity);
    }

    @Override
    public String regisztracioOpt(ReaderDTO felhasznalo) {
        ReaderEntity entity = new ReaderEntity();
        entity.setOsz(felhasznalo.getOsz());
        entity.setNev(felhasznalo.getNev());
        entity.setJelszo(felhasznalo.getJelszo());
        entity.setEmail(felhasznalo.getEmail());
        entity.setCim(felhasznalo.getCim());
        entity.setNem(felhasznalo.getNem());
        entity.setSzuldate(felhasznalo.getSzuldate());
        entity.setTelefon(felhasznalo.getTelefon());
        entity.setJogosultsag(Authorization.USER);

//        return modelMapper.map(readerRepository.save(entity), ReaderDTO.class);

        entity = readerRepository.save(entity);
        return jwtService.generateToken(entity);
    }

    @Override
    public String bejelentkezes(ReaderDTO felhasznalo) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(felhasznalo.getEmail(),
                        felhasznalo.getJelszo())
        );
        var user = readerRepository.findByEmail(felhasznalo.getEmail());
        return jwtService.generateToken(user);
    }


}
