package passwordmanager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHash {
	private static BCryptPasswordEncoder hasher = new BCryptPasswordEncoder(); //instantiates BCryptPasswordEncoder
	
	public static String hash(String pw) {
		return hasher.encode(pw); //hashes the password
	}
	public static boolean checkMatch(String pw, String encoded) {
		return hasher.matches(pw, encoded); //checks whether the password entered is identical to the hashed password
	}
	
	//the below section is to test the code
	public static void main(String[] args) {
		String hash = hash("password_");
		String hash2 = hash("tobleronka");
		System.out.println(hash);
		System.out.println(hash2);
		System.out.println(checkMatch("password", hash)); //expected false
		System.out.println(checkMatch("tobleronka", hash2)); //expected true
	}
}
