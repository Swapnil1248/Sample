import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Password {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Password de");
		String password = sc.nextLine();
		Checker c = new Checker();
		boolean flag = true;
		if (!c.checkLength(password)) {
			flag = false;
			System.out.println("Length");
		}

		if (!c.checkDigit(password)) {
			flag = false;
			System.out.println("Digit");
		}

		if (!c.checkSpecialCharacter(password)) {
			flag = false;
			System.out.println("Character");
		}

		if (flag) {
			boolean samePassword = true;
			while (samePassword) {
				System.out.println("Re-enter your password");
				String rePassword = sc.nextLine();
				if (password.equals(rePassword)) {
					samePassword = false;
					try (FileWriter fWriter = new FileWriter("Lab5.txt")) {
						StringBuffer sb = new StringBuffer();

						for (char eachChar : password.toCharArray()) {
							int asciiVal = (int) eachChar;
							System.out.print(asciiVal);
							sb.append(asciiVal + ",");
						}
						sb.append('0');
						fWriter.write(sb.toString());
						fWriter.flush();
						fWriter.close();
					} catch (IOException e) {

						e.printStackTrace();
					} finally {

					}
				}

			}
		}

	}

}

class Checker {
	String str;
	int requiredLength = 8;

	public boolean checkLength(String str) {
		return (str.length() > requiredLength);
	}

	public boolean checkDigit(String str) {

		boolean found = false;

		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public boolean checkSpecialCharacter(String str) {
		return str.contains("!") || str.contains("@") || str.contains("#") || str.contains("$") || str.contains("*");
	}

}