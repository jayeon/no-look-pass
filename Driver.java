package passwordmanager;

public class Driver {
	public static void main(String[] args) {
		PasswordAssessor assessor = new PasswordAssessor();

		String goodPassword = "Espresso43624!";
		String okPassword = "Espresso43624";
		String mehPassword = "Espresso12345";
		
		String unacceptablePassword = "12345";
		String badPassword = "qwerty";

		System.out.println(assessor.assessPassword(goodPassword));
		System.out.println(assessor.assessPassword(okPassword));
		System.out.println(assessor.assessPassword(mehPassword));
		
		System.out.println(assessor.assessPassword(unacceptablePassword));
		System.out.println(assessor.assessPassword(badPassword));
	}
}