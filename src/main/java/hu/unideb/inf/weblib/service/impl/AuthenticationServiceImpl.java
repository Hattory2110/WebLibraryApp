package hu.unideb.inf.weblib.service.impl;

import hu.unideb.inf.weblib.data.entities.ReaderEntity;
import hu.unideb.inf.weblib.data.repositories.ReaderRepository;
import hu.unideb.inf.weblib.service.AuthenticationService;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ReaderDTO regisztracio(String email, String password) {
        ReaderEntity entity = new ReaderEntity();
        entity.setJelszo(password);
        entity.setEmail(email);

        return modelMapper.map(readerRepository.save(entity), ReaderDTO.class);
    }

    @Override
    public ReaderDTO regisztracioOpt(ReaderDTO felhasznalo) {
        ReaderEntity entity = new ReaderEntity();
        entity.setOsz(felhasznalo.getOsz());
        entity.setNev(felhasznalo.getNev());
        entity.setJelszo(felhasznalo.getJelszo());
        entity.setEmail(felhasznalo.getEmail());
        entity.setCim(felhasznalo.getCim());
        entity.setNem(felhasznalo.getNem());
        entity.setSzuldate(felhasznalo.getSzuldate());
        entity.setTelefon(felhasznalo.getTelefon());
        return modelMapper.map(readerRepository.save(entity), ReaderDTO.class);
    }

    @Override
    public Authentication bejelentkezes(ReaderDTO felhasznalo) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(felhasznalo.getEmail(),
                        felhasznalo.getJelszo())
        );
    }


}
