package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the methods of PasswordChecker
 * @author Professor Kartchner
 *
 */
public class PasswordCheckerTest {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = {"334455BB#", "george2ZZZ#", "4Sal#", "bertha22", "august30", "a2cDe", 
				"ApplesxxxYYzz#", "aa11Bb", "pilotProject", "AAAbb@123"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); // puts strings into the ArrayList
		
	 
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("abcAB"));
			assertTrue("Did not throw lengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		 
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("123456"));
			 
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("123456A"));
 
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{	System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password is weak
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("1234@aA");
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPasswordException",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("123@4aaAAA"));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}

	/**
	 * Test the getInvalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testGetInvalidPasswords() {
 
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		String scan = results.get(0); 
		assertEquals(scan, "334455BB#");
		String nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.hasLowerAlp(nextResults);
			assertTrue("Did not throw NoLowerAlphaException",true);
		}
		catch (NoLowerAlphaException e){
			assertTrue("Successfully threw a NoLowerAlphaException",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		//assertTrue(nextResults.contains("lowercase"));
		
		scan = results.get(1);  
		assertEquals(scan, "george2ZZZ#");
		nextResults = scan.toLowerCase(); 
		try {
			PasswordCheckerUtility.noSameCharSequence(nextResults);
			assertTrue("Did not throw InvalidSequenceException",false);
			
		}
		catch (InvalidSequenceException e){
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
		//assertTrue(nextResults.contains("sequence"));
		
		 
		scan = (results.get(2));  
		assertEquals(scan, "4Sal#");
		nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.isValidLength(nextResults);
			assertTrue("Did not throw LengthException",false);
		}
		catch (LengthException e){
			assertTrue("Successfully threw a LengthException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides LengthException",false);
		}
		//assertTrue(nextResults.contains("long"));
		
		scan = (results.get(3));  
		assertEquals(scan, "bertha22");
		nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.hasUpperAlpha(nextResults);
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch (NoUpperAlphaException e){
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
		//assertTrue(nextResults.contains("uppercase"));
		
		scan = (results.get(4));  
		assertEquals(scan, "august30");
		nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.hasUpperAlpha(nextResults);
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch (NoUpperAlphaException e){
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
//		assertTrue(nextResults.contains("uppercase") );
		
		 
		
		scan = (results.get(5));  
		assertEquals(scan, "a2cDe");
		nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.isValidLength(nextResults);
			assertTrue("Did not throw LengthException",false);
		}
		catch (LengthException e){
			assertTrue("Successfully threw a LengthException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides LengthException",false);
		}
//		assertTrue(nextResults.contains("long") );
		
		scan = (results.get(6));  
		assertEquals(scan, "ApplesxxxYYzz#");
		nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.hasDigit(nextResults);
			assertTrue("Did not throw NoDigitException",false);
		}
		catch (NoDigitException e){
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
//		assertTrue(nextResults.contains("digit") );
		
		scan = (results.get(7));  
		assertEquals(scan, "aa11Bb");
		nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.hasSpecialChar(nextResults);
			assertTrue("Did not throw NoSpecialCharacterException",false);
		}
		catch (NoSpecialCharacterException e){
			assertTrue("Successfully threw a NoSpecialCharacterException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoSpecialCharacterException",false);
		}
//		assertTrue(nextResults.contains("special") );
		
		
		scan = (results.get(8)); 
		assertEquals(scan, "pilotProject");
		nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.hasDigit(nextResults);
			assertTrue("Did not throw NoDigitException",false);
		}
		catch (NoDigitException e){
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
//		assertTrue(nextResults.contains("digit") );
		
		scan = (results.get(9));  
		assertEquals(scan, "AAAbb@123");
		nextResults = scan.toLowerCase();
		try {
			PasswordCheckerUtility.noSameCharSequence(nextResults);
			assertTrue("Did not throw InvalidSequenceException",false);
		}
		catch (InvalidSequenceException e){
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
//		assertTrue(nextResults.contains("sequence") );
 
	}
}
