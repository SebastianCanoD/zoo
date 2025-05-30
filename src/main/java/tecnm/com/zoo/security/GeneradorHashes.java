package tecnm.com.zoo.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneradorHashes {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		System.out.println("admin123: " + encoder.encode("admin123"));
		System.out.println("cuidador123: " + encoder.encode("cuidador123"));
		System.out.println("prueba123: " + encoder.encode("prueba123"));
	}
}
