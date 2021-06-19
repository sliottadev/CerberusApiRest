package com.cerberus.controllers;

import com.cerberus.models.Client;
import com.cerberus.services.IClientService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClientsController Path: "../auth/"
 * Controla: paths que no necesiten autenticacion
 * Entidades relacionadas: Client
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IClientService clientService;

    @GetMapping("test")
    public String HelloTest() {
        return "Hello Auth";
    }

    @PostMapping
    public Client ClientLogin(@RequestBody Client client) {
        return clientService.ClientLogin(client);
    }

    @PostMapping("/register")
    public Client ClientRegister(@RequestBody Client client) {
        return clientService.ClientRegister(client);
    }

    @GetMapping("getToken")
    private String getJWTToken(@RequestParam("nombreToken") String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("cerberusJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Cerberus " + token;
    }
}
