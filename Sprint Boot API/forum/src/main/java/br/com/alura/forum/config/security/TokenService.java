package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.nio.charset.StandardCharsets;

@Service
public class TokenService {

	private final Key signingKey;
	private final long expirationInMilliseconds;

	public TokenService(@Value("${forum.jwt.secret}") String secret,
						@Value("${forum.jwt.expiration}") long expirationInMilliseconds) {
		this.signingKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
		this.expirationInMilliseconds = expirationInMilliseconds;
	}

	public String gerarToken(Authentication authentication) {
		Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
		Date agora = new Date();
		Date dataExpiracao = new Date(agora.getTime() + this.expirationInMilliseconds);

		return Jwts.builder()
				.setIssuer("API do Fórum Alura")
				.setSubject(usuarioLogado.getId().toString())
				.setIssuedAt(agora)
				.setExpiration(dataExpiracao)
				.signWith(this.signingKey)
				.compact();
	}

	public boolean isTokenValido(String token) {
		if (token == null || token.isEmpty()) {
			return false;
		}

		try {
			Jwts.parser()
					.verifyWith((javax.crypto.SecretKey) this.signingKey)
					.build()
					.parseSignedClaims(token);

			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		if (token == null || token.isEmpty()) {
			return null;
		}

		try {
			Jws<Claims> claimsJws = Jwts.parser()
					.verifyWith((javax.crypto.SecretKey) this.signingKey)
					.build()
					.parseSignedClaims(token);

			return Long.parseLong(claimsJws.getBody().getSubject());
		} catch (JwtException | IllegalArgumentException e) {
			return null;
		}
	}

}