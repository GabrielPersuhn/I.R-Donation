/* package br.com.letscode.java.irdonation.autenticacao.token;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${config.token.secret}")
    private String secret;

    public String gerarToken(Authentication authentication){
        Usuario user = (Usuario) authentication.getPrincipal();
        Date criacao = new Date();
        Date expiracao = new Date(criacao.getTime() + 1800000);

        return Jwts.builder().setIssuer("Lets code")
                .setSubject(user.getId().toString())
                .setIssuedAt(criacao)
                .setExpiration(expiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validarToken(String token){
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

} */
