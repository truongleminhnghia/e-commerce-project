    package org.project.ecommerce.jwt;

    import io.jsonwebtoken.Claims;
    import io.jsonwebtoken.Jwts;
    import org.project.ecommerce.configs.CustomUserDetail;
    import org.project.ecommerce.enums.EnumTokenType;
    import org.project.ecommerce.logout.ListToken;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Service;

    import javax.crypto.SecretKey;
    import javax.crypto.spec.SecretKeySpec;
    import java.nio.charset.StandardCharsets;
    import java.util.Base64;
    import java.util.Date;
    import java.util.function.Function;

    @Service
    public class JWTToken {

        @Autowired
        private ListToken listToken;

        @Value("${jwt.refresh.expiration}")
        private int JWT_REFRESH_EXPIRATION;  // 10 ngay

        @Value("${jwt.secret}")
        private String sceretString;

        @Value("${jwt.refresh.secret}")
        private String refreshSecretString;

        @Value("${jwt.expiration}")
        private int JWT_EXPIRATION;

        @Value("${jwt.algorithms}")
        private String algorithm;

        private SecretKey getSecretKey(EnumTokenType type) {
            byte[] keyBytes = null;
            SecretKey SCRET_KEY = null;
            if(type == EnumTokenType.TOKEN) {
                keyBytes = Base64.getDecoder().decode(sceretString.getBytes(StandardCharsets.UTF_8));
                SCRET_KEY = new SecretKeySpec(keyBytes, algorithm);
                return SCRET_KEY;
            } else {
                keyBytes = Base64.getDecoder().decode(refreshSecretString.getBytes(StandardCharsets.UTF_8));
                SCRET_KEY = new SecretKeySpec(keyBytes, algorithm);
                return SCRET_KEY;
            }
        }


        public String generatedToken(CustomUserDetail customUserDetail) {
            Date date = new Date(System.currentTimeMillis());
            Date exp = new Date(System.currentTimeMillis() + JWT_EXPIRATION);
            return Jwts.builder()
                    .subject(customUserDetail.getUsername())
                    .issuedAt(date)
                    .expiration(exp)
                    .claim("userId", customUserDetail.getUserId())
                    .claim("userName", customUserDetail.getUsername())
                    .claim("role", customUserDetail.getGrantedAuthorities())
                    .signWith(getSecretKey(EnumTokenType.REFRESH_TOKEN))
                    .compact();
        }

        public String generatedRefreshToken(CustomUserDetail customUserDetail) {
            Date date = new Date(System.currentTimeMillis());

            Date exp = new Date(System.currentTimeMillis() + JWT_REFRESH_EXPIRATION);

            return Jwts.builder()
                    .subject(customUserDetail.getUsername())
                    .issuedAt(date)
                    .expiration(exp)
                    .claim("userId", customUserDetail.getUserId())
                    .claim("userName", customUserDetail.getUsername())
                    .claim("role", customUserDetail.getGrantedAuthorities())
                    .signWith(getSecretKey(EnumTokenType.REFRESH_TOKEN))
                    .compact();
        }

        public String getEmailFromJwt(String token, EnumTokenType type) {
            return getClaims(token, Claims::getSubject, type);
        }

        private <T> T getClaims(String token, Function<Claims, T> claimsTFunction, EnumTokenType type) {
            return claimsTFunction.apply(
                    Jwts.parser().verifyWith(getSecretKey(type)).build().parseSignedClaims(token).getPayload());
        }
        public boolean validate(String token, EnumTokenType type) {
            if(getEmailFromJwt(token, type) != null && !isExpired(token, type) && !listToken.isListToken(token)) {
                return true;
            }
            return false;
        }

        public boolean isExpired(String token, EnumTokenType type) {
            return getClaims(token, Claims::getExpiration, type).before(new Date(System.currentTimeMillis()));
        }
    }
