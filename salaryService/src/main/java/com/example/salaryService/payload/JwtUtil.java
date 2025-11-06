package com.example.salaryService.payload;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "mySuperSecretKeyThatShouldBeLongEnough12345";

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    /**
     * ✅ Validates the given JWT token
     */
    public boolean validateToken(String token, String username) {
        try {
            Claims claims = getClaims(token);

            String tokenUsername = claims.getSubject();
            Date expiration = claims.getExpiration();

            return (tokenUsername.equals(username) && expiration.after(new Date()));

        } catch (ExpiredJwtException e) {
            System.out.println("❌ JWT expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("❌ JWT unsupported: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("❌ JWT malformed: " + e.getMessage());
        } catch (SignatureException e) {
            System.out.println("❌ Invalid JWT signature: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ JWT claims string is empty: " + e.getMessage());
        }

        return false;
    }
}
