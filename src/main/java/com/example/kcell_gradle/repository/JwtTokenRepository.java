package com.example.kcell_gradle.repository;
/*
 * @author Токмурзин Мукагали
 * @version 1.0
 * @email mukagali.2002.05@gmail.com
 */
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Repository;
/*
* This is token, which used for Security
*
* */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;

@Repository
public class JwtTokenRepository implements CsrfTokenRepository {


    private String secret;

    public String getSecret() {
        return secret;
    }

    public JwtTokenRepository() {
        this.secret = "springrest";
    }

    @Override
    public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
        String id = UUID.randomUUID().toString().replace("-", "");
        Date now = new Date();
        Date exp = Date.from(LocalDateTime.now().plusMinutes(30)
                .atZone(ZoneId.systemDefault()).toInstant());

        String token = "";
        try {
            token = Jwts.builder()
                    .setId(id)
                    .setIssuedAt(now)
                    .setNotBefore(now)
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
        } catch (JwtException e) {
            e.printStackTrace();
            //ignore
        }
        return new DefaultCsrfToken("x-csrf-token", "_csrf", token);
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest request, HttpServletResponse response) {
        if (Objects.nonNull(csrfToken)) {
            if (!response.getHeaderNames().contains(ACCESS_CONTROL_EXPOSE_HEADERS))
                response.addHeader(ACCESS_CONTROL_EXPOSE_HEADERS, csrfToken.getHeaderName());

            if (response.getHeaderNames().contains(csrfToken.getHeaderName()))
                response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
            else
                response.addHeader(csrfToken.getHeaderName(), csrfToken.getToken());
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

    public void clearToken(HttpServletResponse response) {
        if (response.getHeaderNames().contains("x-csrf-token"))
            response.setHeader("x-csrf-token", "");
    }
}
