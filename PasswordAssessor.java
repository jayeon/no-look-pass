package passwordmanager;
	
import java.util.regex.*;

/* 
 * Method returns a score rating the strength of a password
 * Score increase by one for meeting certain criteria like length above eight characters,
 * use of non-repeating characters and a mix of numbers, letters and special characters
 * 
 * The method returns a score of 0 for unacceptable passwords like the following:
 * password shorter than eight characters, common passwords
 * 
 * */
	
public class PasswordAssessor {
	public String[] commonPasswords = {"123456", "Password", "12345678", "qwerty", "12345",
		"123456789", "letmein", "1234567", "football", "iloveyou", 
		"admin", "welcome", "monkey", "login", "abc123", "starwars", "123123", "dragon", 
		"passw0rd", "master", "hello", "freedom", "whatever", "qazwsx",
		"trustno1", "654321", "jordan23", "password1", "1234", "robert", "matthew",
		"jordan", "asshole", "daniel"};

	public boolean containsNumbers(String password) {
		Pattern numbers = Pattern.compile("\\d");
		Matcher matcher = numbers.matcher(password);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containsSpecialCharacters(String password) {
		Pattern specialCharacters = Pattern.compile("\\W");
		Matcher matcher = specialCharacters.matcher(password);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containsLetters(String password) {
		Pattern letters = Pattern.compile("(?i)[a-z]");
		Matcher matcher = letters.matcher(password);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean containsUpperandLowerCase(String password) {
		Pattern upperCase = Pattern.compile("[A-Z]");
		Pattern lowerCase = Pattern.compile("[a-z]");
		Matcher matcher = upperCase.matcher(password);
		Matcher matcher2 = lowerCase.matcher(password);
		if (matcher.find() && matcher2.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	//looks for red flags
	public boolean hasConsecutiveNumbers(String password) {
		Pattern numbersAscending = Pattern.compile("(098|987|876|765|654|543|432|321|210)");
		Pattern numbersDescending = Pattern.compile("(123|234|345|456|567|678|789|890)");
		Matcher matcher = numbersAscending.matcher(password);
		Matcher matcher2 = numbersDescending.matcher(password);
		if (matcher.find() || matcher2.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasRepeatingCharacters(String password) {
		Pattern letters = Pattern.compile("(\\w)\\2+");
		Matcher matcher = letters.matcher(password);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isCommonPassword(String password) {		
		for (String commonPassword : commonPasswords) {
			if (password.equals(commonPassword)) {
				return true;
			}
		}
		return false;
	}
	
	//length	
	public boolean eightOrLonger (String password) {
		if (password.length() >= 8) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean twelveOrLonger (String password) {
		if (password.length() >= 12) {
			return true;
		} else {
			return false;
		}
	}
	
	public int assessPassword(String password) {	
		int passwordScore = 0;
		
		if (containsLetters(password) 
				&& containsNumbers(password)
				&& containsSpecialCharacters(password)) {
			passwordScore = 1;
		}
		
		if (containsUpperandLowerCase(password)) {
			passwordScore += 1;
		}
		
		if (hasRepeatingCharacters(password) == false) {
			passwordScore += 1;
		}
		
		if (hasConsecutiveNumbers(password) == false) {
			passwordScore += 1;
		}
		
		if (isCommonPassword(password)) {
			passwordScore = 0;
		} else {
			passwordScore += 1;
		}
		
		//length		
		if (eightOrLonger(password) == true) {
			passwordScore += 1;
		} else {
			passwordScore = 0;
		}
		
		if (twelveOrLonger(password) == true) {
			passwordScore += 1;
		}
		
		return passwordScore;
	}
}