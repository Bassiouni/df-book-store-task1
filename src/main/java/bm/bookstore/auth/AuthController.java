package bm.bookstore.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Log4j2
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest register) {
        log.debug("Registering username " + register.getUsername());
        return ResponseEntity.ok(authService.register(register));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest register) {
        log.debug("Authenticating username " + register.getUsername());
        return ResponseEntity.ok(authService.authenticate(register));
    }
}
