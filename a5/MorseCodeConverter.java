package a5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Lap
 * @version 11/27
 */
public class MorseCodeConverter {
	private static MorseCodeTree mTree = new MorseCodeTree();
	
	//Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		String convert="";
		Scanner s = new Scanner(codeFile);
		while(s.hasNext()) {
			convert+=convertToEnglish(s.nextLine());
		}
		return convert;
	}
	
	//Converts Morse code into English.
	public static String convertToEnglish(String code) {
		String convertedString="";
		
		String[] MorseWords = code.split("/");
		for(int i=0;i<MorseWords.length;i++) {
			if (MorseWords[i].charAt(0)==' ')
				MorseWords[i]=MorseWords[i].substring(1); // if first char is space, remove it
			String[] MorseLetters = MorseWords[i].split(" ");
			String[] Letters = new String[MorseLetters.length];
			int count=0;
			
			for (String n:MorseLetters) {
				Letters[count++] = mTree.fetch(n);
			}
			String word= String.join("", Letters);
			convertedString+=word+" ";}
		
		//remove last character, which should be a space
		return convertedString.substring(0, convertedString.length()-1);
	}
	
	//returns a string with all the data in the tree in LNR order with an space in between them.
	public static String printTree() {
		String mTreeChar=String.join(" ", mTree.toArrayList());
		return mTreeChar;
	}
}
