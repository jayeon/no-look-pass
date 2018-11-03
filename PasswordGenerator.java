package passwordmanager;
/* 
 * The method generates a strong password using the following features:
 * 1. It is between 12-16 characters long
 * 2. It has a combination of numbers, letters and special characters
 * 3. The letters consist both of uppercase and lowercase characters
 * 4. The letters are not dictionary words
 * */


public class PasswordGenerator {	
	public String generatePassword() {
		String strongPassword = "";
		int passwordLength = (int) (Math.random() * 5 + 12); //returns a minimum of 12
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String integers = "0123456789";
		String specialCharacters = "!" + "\"" + "#$%&" + "\'" + "()*,+-./:\\;<=>?@[\\]^_`{|}~";		
		
		for (int i = 0; i < passwordLength; i++) {
			int a = (int) (Math.random() * 3); //generates a number between 0 and 2
			if (a == 0) {
				int index = (int) (Math.random() * alphabet.length());
				strongPassword += alphabet.charAt(index);
			} else if (a == 1) {
				int index2 = (int) (Math.random() * integers.length());
				strongPassword += integers.charAt(index2);
			} else {
				int index3 = (int) (Math.random() * specialCharacters.length());
				strongPassword += specialCharacters.charAt(index3);
			}
		}		
		return strongPassword;
	}
}
