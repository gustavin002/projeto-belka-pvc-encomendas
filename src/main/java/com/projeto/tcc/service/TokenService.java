/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.service;

import com.projeto.tcc.model.AdminDTO;
import com.projeto.tcc.model.UsuarioDTO;
import com.projeto.tcc.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.Optional;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public SecretKey getKeySign() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String gerarToken(UsuarioDTO user) {
        if (user.getIdUsuario() == 0) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Id do usuário inválido");
        }
        if (user.getNomeUsuario() == null || user.getNomeUsuario().equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Nome do usuário faltante");
        }
        if (user.getEmailUsuario() == null || user.getEmailUsuario().equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Email do usuário faltante");
        }
        if (user.getRoleUsuario() == null || user.getRoleUsuario().equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Role do usuário faltante");
        }

        return Jwts.builder()
                .subject(user.getNomeUsuario())
                .claim("id", user.getIdUsuario())
                .claim("nome", user.getNomeUsuario())
                .claim("role", user.getRoleUsuario())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3000000))
                .signWith(this.getKeySign())
                .compact();
    }

    public String gerarToken(AdminDTO admin) {
        if (admin.getIdAdmin() == 0) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Id do admin inválido");
        }
        if (admin.getEmailAdmin() == null || admin.getEmailAdmin().equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Email do admin faltante");
        }
        return Jwts.builder()
                .subject("Administrador")
                .claim("id", admin.getIdAdmin())
                .claim("nome", "Administrador")
                .claim("role", "admin")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1800000))
                .signWith(this.getKeySign())
                .compact();
    }

    public UsuarioDTO extrairClaim(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(this.getKeySign())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        Integer id = claims.get("id", Integer.class);

        Optional<UsuarioDTO> resultado = usuarioRepository.findById(id);

        if (resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Usuário do token não encontrado");
        }

        return resultado.get();
    }

    public int extrairId(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(this.getKeySign())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.get("id", Integer.class);
    }

    public String extrairRole(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(this.getKeySign())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.get("role", String.class);
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(this.getKeySign())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
        
    }

}