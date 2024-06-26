package com.elice.team4.singleShop.user.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider){
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String accessToken = getTokenFromRequest(request, "Authorization");

        log.info("[doFilterInternal] accessToken 값 추출 완료, token: {}", accessToken);

        log.info("[doFilterInternal] accessToken 값 유효성 체크 시작");

        if (accessToken != null && jwtTokenProvider.validateToken(accessToken)) {
            Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("[doFilterInternal] accessToken 값 유효성 체크 완료");
        } else {
            log.warn("[doFilterInternal] AccessToken이 만료되었습니다.");
            refreshAuthentication(request, response);
        }

        filterChain.doFilter(request, response);
    }

    private void refreshAuthentication(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String refreshToken = getTokenFromRequest(request, "Refresh");
        if (refreshToken != null && jwtTokenProvider.validateToken(refreshToken)) {
            log.info("[refreshToken] RefreshToken으로 AccessToken 재발급 시작");
            String accessToken = jwtTokenProvider.createToken(jwtTokenProvider.getUserPk(refreshToken),
                    jwtTokenProvider.getUserInfo(jwtTokenProvider.getUserPk(refreshToken)).getRole());
            Authentication authentication = jwtTokenProvider.getAuthentication(accessToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Cookie cookie = new Cookie("Authorization", accessToken);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            log.info("[refreshToken] AccessToken이 재발급 되었습니다.");
        } else {
            log.warn("[refreshToken] RefreshToken이 만료 되었습니다.");
        }
    }

    private String getTokenFromRequest(HttpServletRequest request, String tokenName) throws UnsupportedEncodingException {
        if (request.getCookies() != null) {
            Optional<Cookie> tokenCookie = Arrays.stream(request.getCookies())
                    .filter(
                            cookie -> cookie.getName().equals(tokenName)
                    ).findFirst();

            if (tokenCookie.isPresent()) {
                String token = URLDecoder.decode(tokenCookie.get().getValue(), "UTF-8");
                if (token != null && token.startsWith("Bearer ")) {
                    return token.substring(7);
                }
                log.info(token);
            }
        }
        return null;
    }
}
