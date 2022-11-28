package a5;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MorseCodeConverterTest {

	//TODO
	//1 MorseCodeConverter.convertToEnglish(String)test
	//1 test for MorseCodeConverter.convertToEnglish(File) 
	//TODO
	
	@Test
	public void testConvertToEnglishFile() {
		File file = new File("src/LoveLooksNot.txt"); 
		File file2 = new File("src/smoothSailing.txt"); 
		File file3 = new File("src/Daisy.txt"); 
		File file4 = new File("src/DaisyDaisy.txt"); 
		try {
			assertEquals("love looks not with the eyes but with the mind", MorseCodeConverter.convertToEnglish(file));
			assertEquals("smooth sailing", MorseCodeConverter.convertToEnglish(file2));
			assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(file3));
			assertEquals("im half crazy all for the love of you", MorseCodeConverter.convertToEnglish(file4));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

	@Test
	public void testConvertToEnglishString() {
		String converter1 = MorseCodeConverter.convertToEnglish("-.-. .- .-. .--. . / -.. .. . --");
		assertEquals("carpe diem", converter1);
		
		String converter2 = MorseCodeConverter.convertToEnglish("...- . -. .. / ...- .. -.. .. / ...- .. -.-. ..");
		assertEquals("veni vidi vici", converter2);
	}

}
