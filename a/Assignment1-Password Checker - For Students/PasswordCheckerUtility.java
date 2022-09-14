package application;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;
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
	/**
	 * check a list of passwords and return a list of invalid password
	 * @param list of unchecked passwords
	 * @return list of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalidPasswords= new ArrayList<String>();
		for (int n=0;n<passwords.size();n++) {
			try {
				isValidPassword(passwords.get(n));
			} catch (Exception e) {
				invalidPasswords.add(passwords.get(n));
			}
		}
		return invalidPasswords;
	}

	/**
	 * check if password is valid
	 * @param user inputed password
	 * @return
	 * @throws LengthException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws InvalidSequenceException 
	 * @throws NoUpperAlphaException 
	 * @throws NoSpecialCharacterException 
	 */
	public static boolean isValidPassword(String pass) throws LengthException, NoDigitException, NoLowerAlphaException, InvalidSequenceException, NoUpperAlphaException, NoSpecialCharacterException {
		isValidLength(pass);
		hasUpperAlpha(pass);
		hasLowerAlp(pass);
		hasSpecialChar(pass);
		hasDigit(pass);
		noSameCharSequence(pass);
		return true;
	}

	/**
	 * check if password is of valid length and return message depend on the length of the password
	 * @param user inputed password
	 * @return
	 * @throws LengthException 
	 */
	public static boolean isValidLength(String pass) throws LengthException{
		if( pass.length()<6)
			throw new LengthException();
		return true;
	}
	/**
	 * check if password is valid and weak
	 * @param pass
	 * @return
	 */
	public static boolean isWeakPassword(String pass) throws WeakPasswordException{
		if(pass.length()>5 && pass.length()<10) {
			throw new WeakPasswordException();}
		return false;
	}
	/**
	 * check if password contain digit, throw exception if not
	 * @param user input password
	 * @return
	 */
	public static boolean hasDigit(String pass) throws NoDigitException{
		pattern=Pattern.compile("[1-9]+");
		matcher= pattern.matcher(pass);
		if (!matcher.find())
				throw new NoDigitException();
		return(!matcher.matches());
	}

	/**
	 * check if password contain 3 same character in a row, throw exception if true
	 * @param user inputed password
	 * @return false if password contain 3 same character in a row
	 */
	public static boolean noSameCharSequence(String pass) throws InvalidSequenceException{
		for (int n=0; n<pass.length()-2;n++)
			if ((pass.charAt(n)==pass.charAt(n+1))&&(pass.charAt(n)==pass.charAt(n+2)))
				throw new InvalidSequenceException();
		return true;
	}
	
	/**
	 * check if password contain lower case character, throw exception if not
	 * @param user inputed password
	 * @return
	 */
	public static boolean hasLowerAlp(String pass) throws NoLowerAlphaException{
		pattern=Pattern.compile("[a-z]+");
		matcher= pattern.matcher(pass);
		if (!matcher.find())
				throw new NoLowerAlphaException();
		return(!matcher.matches());
		
	}
	

	/**
	 * check if password contain upper case character, throw exception if not
	 * @param user inputed password
	 * @return
	 */
	public static boolean hasUpperAlpha(String pass) throws NoUpperAlphaException{
		Pattern pattern=Pattern.compile("[A-Z]+");
		Matcher matcher= pattern.matcher(pass);
		if (!matcher.find())
				throw new NoUpperAlphaException();
		return(!matcher.matches());
	}
	

	/**
	 * check if password contain special character, throw exception if not
	 * @param user inputed password
	 * @return
	 */
	public static boolean hasSpecialChar(String pass) throws NoSpecialCharacterException{
		pattern=Pattern.compile("[~!@#$%^&*()_+{}\\[\\]:;,.<>/?-]+");
		matcher= pattern.matcher(pass);
		if (!matcher.find())
				throw new NoSpecialCharacterException();
		return(!matcher.matches());
	}
	
	/**
	 * @param both are user inputed passwords, throw exception if they do not match 
	 * @return if the two passwords is the same 
	 */
	public static boolean comparePasswordsWithReturn(String pass, String passConf) throws UnmatchedException{
		if(!pass.equals(passConf))
			throw new UnmatchedException();
		return true;
	}

	/**
	 * @param both are user inputed passwords, throw exception if they do not match 
	 */
	public static void comparePasswords(String pass, String passConf) throws UnmatchedException{
		if(!pass.equals(passConf))
			throw new UnmatchedException(); 
	}
	
}