package bm.bookstore.auth;

import bm.bookstore.config.JwtService;
import bm.bookstore.entities.UserEntity;
import bm.bookstore.repository.UserRepository;

import java.util.Optional;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AuthService {
	private final UserRepository userRepository;

	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
			AuthenticationManager authenticationManager) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthResponse register(RegisterRequest request) {
		UserEntity user = UserEntity
				.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.build();

		userRepository.save(user);
		String token = jwtService.generateToken(user);
		return AuthResponse
				.builder()
				.token(token)
				.build();
	}

	public AuthResponse authenticate(AuthRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(),
						request.getPassword()));

		Optional<UserEntity> user = userRepository.findByUsername(request.getUsername());
		if (user.isEmpty()) {
			log.info("authenticating a non-existing user; falling back to empty token");
			return AuthResponse
					.builder().build();
		}

		String token = jwtService.generateToken(user.get());

		return AuthResponse
				.builder()
				.token(token)
				.build();
	}
}
