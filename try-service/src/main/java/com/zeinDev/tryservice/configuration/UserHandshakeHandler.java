package com.zeinDev.tryservice.configuration;
import com.sun.security.auth.UserPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import java.security.Principal;
import java.util.Map;
public class UserHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            // Assuming the principal name is what you want to use to identify the user.
            return new UserPrincipal(authentication.getName());
        } else {
            // Handle the case where there is no authentication.
            // This could be returning null or throwing an exception based on your security requirements.
            return null; // or throw new SomeException("User is not authenticated.");
        }
    }
}
