package a4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	private CourseDBStructure CBS;
	
	public CourseDBManager() {
		CBS= new CourseDBStructure(20);
	}
	
	/**
	 * @param n - estimated numbers of course
	 */
	public CourseDBManager(int n) {
		CBS= new CourseDBStructure(n);
	}
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement e = new CourseDBElement(id,crn,credits,roomNum,instructor);
		CBS.add(e);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			CourseDBElement x =CBS.get(crn);
			return x;
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		int CRN,credits=0;
		Scanner r = new Scanner(input);
		while(r.hasNextLine()) {
			String s= r.nextLine();
			String[] sList=s.split(" ", 5);// split string into Course,CRN,credits, room, and instructor
			CRN =Integer.parseInt(sList[1]);
			credits =Integer.parseInt(sList[2]);
			
			CourseDBElement e = new CourseDBElement(sList[0],CRN,credits,sList[3],sList[4]);
			CBS.add(e);
		}
		r.close();
	}

	@Override
	public ArrayList<String> showAll() {
		return CBS.showAll();
	}

}
