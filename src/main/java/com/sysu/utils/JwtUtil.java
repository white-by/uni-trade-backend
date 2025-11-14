package com.sysu.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key;
    private final long expiration;

    /**
     * 构造方法注入
     */
    public JwtUtil(@Value("${jwt.secret}") String secret,
                   @Value("${jwt.expiration}") long expiration) {
        // 参数验证
        if (secret == null || secret.trim().isEmpty()) {
            throw new IllegalStateException("JWT secret 不能为空");
        }
        if (secret.length() < 32) {
            throw new IllegalStateException("JWT secret 长度至少需要32位");
        }

        // 初始化
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expiration = expiration;
    }

    /**
     * 生成 token
     */
    public String createToken(String id) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析 token，返回用户ID
     */
    public String parseToken(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (ExpiredJwtException e) {
            throw new JwtException("Token 已过期", e);
        } catch (MalformedJwtException e) {
            throw new JwtException("Token 格式错误", e);
        } catch (Exception e) {
            throw new JwtException("Token 解析失败", e);
        }
    }

    /**
     * 检查 token 是否有效
     */
    public boolean isValid(String token) {
        try {
            parseToken(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * 获取 token 剩余有效期（毫秒）
     */
    public long getRemainingExpiration(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getExpiration().getTime() - System.currentTimeMillis();
        } catch (Exception e) {
            return -1;
        }
    }
}