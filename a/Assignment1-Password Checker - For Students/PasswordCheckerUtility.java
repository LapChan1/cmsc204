package a1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * utility class used to check if passwords match criteria and compare passwords
 * @author Lap Wu
 * @version
 */
public class PasswordCheckerUtility { 
		
	private static Pattern pattern;
	private static Matcher matcher;
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> invalidPass) {
		
	}

	/**
	 * check if password is valid
	 * @param user inputed password
	 * @return
	 */
	public static boolean isValidPassword(String pass) {
		
	}

	/**
	 * check if password is of valid length and return message depend on the length of the password
	 * @param user inputed password
	 * @return
	 */
	public static boolean isValidLength(String pass) throws LengthException,WeakPasswordException{
		try {
			if( pass.length()<6)
				throw new LengthException();
			else if(5>pass.length() && pass.length()<10)
				throw new WeakPasswordException();
			return true;
		}
		catch (LengthException s){
			return false;
		}
		catch (WeakPasswordException s2){
			return false;
		}
		
	}
	/**
	 * check if password contain digit
	 * @param user input password
	 * @return
	 */
	public static boolean hasDigit(String pass) throws NoDigitException{
		pattern=Pattern.compile("[1-9]+");
		matcher= pattern.matcher(pass);
		return(!matcher.matches());
	}

	/**
	 * check if password contain 3 same character in a row
	 * @param user inputed password
	 * @return false if password contain 3 same character in a row
	 */
	public static boolean noSameCharSequence(String pass) {
		for (int n=0; n<pass.length()-2;n++)
			if ((pass.charAt(n)==pass.charAt(n+1))&&(pass.charAt(n)==pass.charAt(n+2)))
				return false; //password fail
		return true; //password success
	}
	
	/**
	 * check if password contain lower case character
	 * @param user inputed password
	 * @return
	 */
	public static boolean hasLowerAlp(String pass) {
		pattern=Pattern.compile("[a-z]+");
		matcher= pattern.matcher(pass);
		return(!matcher.matches());
	}
	

	/**
	 * check if password contain upper case character
	 * @param user inputed password
	 * @return
	 */
	public static boolean hasUpperAlp(String pass) {
		pattern=Pattern.compile("[A-Z]+");
		matcher= pattern.matcher(pass);
		return(!matcher.matches());
	}
	

	/**
	 * check if password contain special character
	 * @param user inputed password
	 * @return
	 */
	public static boolean hasSpecialChar(String pass) {
		pattern=Pattern.compile("[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-]+");
		matcher= pattern.matcher(pass);
		return(!matcher.matches());
	}
	
	/**
	 * @param both are user inputed passwords
	 * @return if the two passwords is the same 
	 */
	public static boolean comparePasswordBool(String pass, String passConf) {
		if(pass.equals(passConf))
			return true;
		return false;
	}
	
}