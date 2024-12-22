package hu.unideb.inf.weblib.controller;

import hu.unideb.inf.weblib.service.AuthenticationService;
import hu.unideb.inf.weblib.service.dto.LoginDTO;
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
    public String registracioOpt(@RequestBody ReaderDTO felhasznalo) {
        return authenticationService.regisztracioOpt(felhasznalo);
    }

    @PostMapping("/reg")
    public String registracio(@RequestBody String email, String password) {
        return authenticationService.regisztracio(email, password);
    }

    @PostMapping("/login")
    public String bejelentkezes(@RequestBody LoginDTO loginDTO){
        return authenticationService.bejelentkezes(loginDTO);
    }
}
