package passwordmanager;
/* 
 * The method generates a strong password using the following features:
 * 1. It is between 12-16 characters long
 * 2. It has a combination of numbers, letters and special characters
 * 3. The letters consist both of uppercase and lowercase characters
 * */

public class PasswordGenerator {
	PasswordAssessor assessor = new PasswordAssessor();
	
	public String generatePassword() {
		String strongPassword = "";
		//randomly generates password length between 12 and 16
		int passwordLength = (int) (Math.random() * 5 + 12); //returns a minimum of 12
		
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String integers = "0123456789";
		String specialCharacters = "!" + "\"" + "#$%&" + "\'" + "()*,+-./:\\;<=>?@[\\]^_`{|}~";		
		
		
		//generates a random combination of letters, numbers and special characters
		for (int i = 0; i < passwordLength; i++) {
			int a = (int) (Math.random() * 3); //generates a number between 0 and 2
			if (a == 0) {
				int index = (int) (Math.random() * 26);
				int upperOrLower = (int) (Math.random() * 2);
				if (upperOrLower == 0) { 
					strongPassword += lowerCase.charAt(index);
				} else {
					strongPassword += upperCase.charAt(index);
				}
			} else if (a == 1) {
				int index2 = (int) (Math.random() * integers.length());
				strongPassword += integers.charAt(index2);
			} else {
				int index3 = (int) (Math.random() * specialCharacters.length());
				strongPassword += specialCharacters.charAt(index3);
			}
		}
		
		//method generates a new strong password if its strength is not the maximum possible (7)
		if (assessor.assessPassword(strongPassword) == 7) {
			return strongPassword;
		} else {
			return generatePassword();
		}
	}
}
