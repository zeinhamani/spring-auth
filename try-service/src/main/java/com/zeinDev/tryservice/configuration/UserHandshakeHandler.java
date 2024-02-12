package com.zeinDev.tryservice.configuration;

import com.sun.security.auth.UserPrincipal;
 // Import your JWT service
import com.zeinDev.tryservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import java.security.Principal;
import java.util.Map;

@Component
public class UserHandshakeHandler extends DefaultHandshakeHandler {
    private final JwtService jwtService;

    public UserHandshakeHandler(JwtService jwtService) {
        this.jwtService = jwtService;
    }


    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        String token = extractToken(request);
        if (token != null && jwtService != null) {
            try {
                if (jwtService.extractUsername(token) != null) {
                    // Token is valid and username is extracted
                    return new UserPrincipal(jwtService.extractUsername(token));
                }
            } catch (Exception e) {
                // Handle token validation failure
            }
        }
        return null; // or handle invalid token scenario
    }

    private String extractToken(ServerHttpRequest request) {
        String query = request.getURI().getQuery();
        if (query != null) {
            for (String param : query.split("&")) {
                if (param.startsWith("token=")) {
                    return param.split("=")[1];
                }
            }
        }
        return null;
    }
}
