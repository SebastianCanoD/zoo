package tecnm.com.zoo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsManager usuarios(DataSource dataSource) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.setUsersByUsernameQuery("SELECT username, password, enabled FROM usuarios WHERE username = ?");
		users.setAuthoritiesByUsernameQuery("SELECT username, rol AS authority FROM usuarios WHERE username = ?");
		return users;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				// Recursos estáticos públicos
				.requestMatchers("/imagenes/**").permitAll()

				// Páginas públicas
				.requestMatchers("/", "/inicio", "/animales", "/especies", "/habitats", "/cuidadores",
						"/detalleanimal/**", "/mapa", "/buscar", "/buscarEspecie", "/buscarHabitat", "/login")
				.permitAll()

				// Rutas de administrador
				.requestMatchers("/admin/**", "/admin/inicioadmin").hasAuthority("ADMINISTRADOR")

				// Rutas de cuidadores
				.requestMatchers("/cuidadores/**", "/cuidadores/iniciocuidador").hasAuthority("CUIDADOR")

				// Todo lo demás requiere autenticación
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").successHandler(customAuthenticationSuccessHandler())
						.permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll())
				.exceptionHandling(handling -> handling.accessDeniedPage("/denegado"));

		return http.build();
	}

	@Bean
	public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
		return (request, response, authentication) -> {
			if (authentication != null && authentication.getAuthorities().stream()
					.anyMatch(a -> a.getAuthority().equals("ADMINISTRADOR"))) {
				response.sendRedirect("/admin/inicioadmin");
			} else if (authentication != null
					&& authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CUIDADOR"))) {
				response.sendRedirect("/cuidadores/iniciocuidador");
			} else {
				response.sendRedirect("/inicio");
			}
		};
	}
}