package com.example.expense_tracker.v1.util;

import com.example.expense_tracker.v1.model.UserModel;
import com.example.expense_tracker.v1.repo.UserRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    private final UserRepo userRepo;
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration-amount-time}")
    private int accessTokenExpiration;

    @Value("${jwt.expiration-refresh-token}")
    private int refreshTokenExpiration;

    private String generateToken(UserModel user, int expiration) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        return Jwts.builder()
                .subject(user.getEmail())
                .claims(claims)
                .signWith(getKey())
                .expiration(new Date(System.currentTimeMillis() + expiration * 1000L))
                .compact();
    }

    public String generateAccessToken(UserModel user) {
        return generateToken(user, accessTokenExpiration);
    }

    public String generateRefreskToken(UserModel user) {
        return generateToken(user, refreshTokenExpiration);
    }

    public SecretKey getKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser().verifyWith(getKey()).build().parseEncryptedClaims(token).getPayload();

    }

    public <T> T extractClaim(String token, Function<Claims, T> func) {
        return func.apply(getAllClaims(token));
    }

    public boolean isTokenExpired(String token) {
        Date date = this.extractClaim(token, Claims::getExpiration);
        return date.before(new Date());
    }

    public boolean isTokenValid(String token) {
        if (isTokenExpired(token)) return false;
        String email = extractClaim(token, Claims::getSubject);
        Optional<UserModel> foundUser = userRepo.findByEmail(email);
        return foundUser.isPresent();
    }

    public UserModel getUserDetail(String token) {
        if (isTokenExpired(token)) return null;
        String email = extractClaim(token, Claims::getSubject);
        Optional<UserModel> foundUser = userRepo.findByEmail(email);
        return foundUser.orElse(null);
    }
}
