package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Lap Wu
 * @version 9/13
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> ps;
	
	@Before
	public void setUp() throws Exception {
		String[] p= {"dwa","DNDN312!","dwjraaw1","dwawaaaw1W","!dwawaaw1W"};
		ps= new ArrayList<String>();
		ps.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		ps=null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("asdB!2315rsdf"));
			assertTrue(PasswordCheckerUtility.isValidPassword("asd"));
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
		
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("dB!215rs"));
			assertTrue("Did not throw lengthException",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Threw some other exception besides lengthException",true);
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
			assertTrue(PasswordCheckerUtility.isValidPassword("bacsdwad!2"));
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
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Bbacsdw!1"));
			assertTrue("Did not throw NoUpperAlphaException",true);
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
			assertTrue(PasswordCheckerUtility.isValidPassword("GHJKS71!"));
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
		assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("GHhKS71!"));
			assertTrue("Did not throw NoLowerAlphaException",true);
		}
		catch(NoLowerAlphaException e)
		{
		assertTrue("Successfully threw a NoLowerAlphaException",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("GHJ71!"));
			assertTrue("Did not throw WeakPasswordException",false);
		}
		catch(WeakPasswordException e)
		{
		assertTrue("Successfully threw a WeakPasswordException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides WeakPasswordException",false);
		}
		
		try{
			assertFalse(PasswordCheckerUtility.isWeakPassword("GHhKS7132!d"));
			assertTrue("Did not throw WeakPasswordException",true);
		}
		catch(WeakPasswordException e)
		{
		assertTrue("Successfully threw a WeakPasswordException",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides WeakPasswordException",false);
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
			assertTrue(PasswordCheckerUtility.isValidPassword("GHaJJJKS71!"));
			assertTrue("Did not throw InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
		assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("GHJ45aHKS71!"));
			assertTrue("Did not throw InvalidSequenceException",true);
		}
		catch(InvalidSequenceException e)
		{
		assertTrue("Successfully threw a InvalidSequenceException",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("GHaJJnioKS!"));
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
		assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("GHJ4aHKS71!"));
			assertTrue("Did not throw NoDigitException",true);
		}
		catch(NoDigitException e)
		{
		assertTrue("Successfully threw a NoDigitException",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("GHaJJ3nioKS!"));
			assertTrue("Did not throw Exception",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw Exception",false);
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalids;
		String inv;
		invalids =PasswordCheckerUtility.getInvalidPasswords(ps);
		System.out.println(invalids);
		
		inv=invalids.get(0);
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(inv));
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

		inv=invalids.get(1);
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(inv));
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
		assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}

		inv=invalids.get(2);
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(inv));
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
		assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}

		inv=invalids.get(3);
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(inv));
			assertTrue("Did not throw NoSpecialCharacterException",false);
		}
		catch(NoSpecialCharacterException e)
		{
		assertTrue("Successfully threw a NoSpecialCharacterException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoSpecialCharacterException",false);
		}
		
	}
	
}
