package passwordmanager;

public class Driver {
	public static void main(String[] args) {
		PasswordAssessor assessor = new PasswordAssessor();
		PasswordGenerator generator = new PasswordGenerator();

		String goodPassword = "Espresso43624!";
		String okPassword = "Espresso43624";
		String mehPassword = "Espresso12345";
		
		String unacceptablePassword = "12345";
		String badPassword = "qwerty";
		
		String strongPassword = generator.generatePassword();
		String strongPassword2 = generator.generatePassword();
		String strongPassword3 = generator.generatePassword();

		System.out.println(assessor.assessPassword(goodPassword));
		System.out.println(assessor.assessPassword(okPassword));
		System.out.println(assessor.assessPassword(mehPassword));
		
		System.out.println(assessor.assessPassword(unacceptablePassword));
		System.out.println(assessor.assessPassword(badPassword));
		
		System.out.println("password: " + strongPassword + "password strength: " + assessor.assessPassword(strongPassword));
		System.out.println("password: " + strongPassword2 + "password strength: " + assessor.assessPassword(strongPassword2));
		System.out.println("password: " + strongPassword3 + "password strength: " + assessor.assessPassword(strongPassword3));
	}
}