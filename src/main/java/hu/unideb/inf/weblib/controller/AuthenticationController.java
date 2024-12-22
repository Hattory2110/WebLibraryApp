package hu.unideb.inf.weblib.controller;

import hu.unideb.inf.weblib.service.AuthenticationService;
import hu.unideb.inf.weblib.service.dto.ReaderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/reg_opt")
    public ReaderDTO registracioOpt(@RequestBody ReaderDTO felhasznalo) {
        return authenticationService.regisztracioOpt(felhasznalo);
    }

    @PostMapping("/reg")
    public ReaderDTO registracio(@RequestBody String email, String password) {
        return authenticationService.regisztracio(email, password);
    }

    @PostMapping("/login")
    public void bejelentkezes(@RequestBody ReaderDTO felhasznaloDto){
        authenticationService.bejelentkezes(felhasznaloDto);
    }
}
