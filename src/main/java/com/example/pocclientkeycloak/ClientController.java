package com.example.pocclientkeycloak;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {


    @GetMapping("/coockie")
    String coockie(@AuthenticationPrincipal OidcUser oidcUser){
        return String.format("""                
                <h3>Principal: %s</h3>
                <h3>Authorities: %s</h3>
                <h3>Jwt: %s</h3>
                """, oidcUser, oidcUser.getAuthorities(), oidcUser.getIdToken().getTokenValue());
    }

    @GetMapping("/privado")
    String privado(@AuthenticationPrincipal Jwt jwt){
        return String.format("""                
                <h3>Principal: %s</h3>     
                <h3>Jwt: %s</h3>
                """, jwt.getClaims(), jwt.getTokenValue());
    }

    @GetMapping("/publico")
    String publico(){
        return "Esse é publico";
    }
}
