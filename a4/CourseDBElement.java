package a4;

public class CourseDBElement implements Comparable<CourseDBElement>{
	private String CourseID,roomNum,instructor;
	private int CRN,credits;
	
	public CourseDBElement(String id,int crn,int cred,String room, String ins) {
		CourseID=id;
		roomNum=room;
		instructor=ins;
		CRN=crn;
		credits=cred;
	}
	
	public CourseDBElement() {
		CourseID=roomNum=instructor=null;
		CRN=credits=0;
	}
	
	public int getCRN() {
		return this.CRN;
	}
	
	public int getCredits() {
		return this.credits;
	}

	public String getID() {
		return this.CourseID;
	}
	
	public String getRoomNum() {
		return this.roomNum;
	}
	
	public String getInstructor() {
		return this.instructor;
	}
	
	@Override
	public int compareTo(CourseDBElement e2) {
		if (CRN==e2.CRN)
			return 0;
		else if (CRN> e2.CRN)
			return 1;
		else
			return -1;
	}
	
	public String toString() {
		return "Course:"+CourseID +	" CRN:"+ CRN +" Credits:"+credits+	" Instructor:"+instructor + " Room:"+ roomNum ;
	}
	
	public int hashCode() {
		String c= String.valueOf(CRN);
		
		return c.hashCode();
	}

}
