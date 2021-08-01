package studentAbstract;


public abstract class Student {
	private final String title;
	private final String firstName;
	private final String lastName;
	private final String studentNumber;
	private final int birthDate;
	private final int birthMonth;
	private final int birthYear;
	
	public Student() {
		this.title = "Mr";
		this.firstName = "Raj";
		this.lastName = "Mehta";
		this.studentNumber = "33459467";
		this.birthDate = 01;
		this.birthMonth = 01;
		this.birthYear = 1998;
	}

	public Student(String title, String firstName, String lastName, String studentNumber, int birthDate, int birthMonth, int birthYear) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentNumber = studentNumber;
		this.birthDate = birthDate;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
	}

	/**
	* function to get the title
	* @return String value of the
	title
	*/

	public String getTitle() {
		return title;
	}

	/**
	* Get the first Name
	* @return String value of the
	first name
	*/

	public String getFirstName()
	{
		return firstName;
	}

	/**
	* Get the last Name
	* @return String value of the
	last name
	*/

	public String getLastName() {
		return lastName;
	}

	/**
	* Get the student number
	* @return String value of the
	student number
	*/

	public String getStudentNumber() {
		return studentNumber;
	}

	/**
	* Get the birth date
	* @return integer value of
	the birth date
	*/

	public int getBirthDate() {
		return birthDate;
	}

	/**
	* Get the birth month
	* @return integer value of
	the birth month
	*/

	public int getBirthMonth() {
		return birthMonth;
	}

	/**
	* Get the birth year
	* @return integer value of
	the birth year
	*/

	public int getBirthYear() {
		return birthYear;
	}

	/**
	* Checking two students
	object whether they have the same details
	* @param other Student Object
	* @return Boolean value
	indicating both student object are the same or not
	*/

	public boolean equals(Student other) {
	  return (this.birthDate == other.getBirthDate() && this.birthMonth == other.getBirthMonth() &&
			  this.firstName.equalsIgnoreCase(other.getFirstName()) && this.lastName.equalsIgnoreCase(other.getLastName()));

	}

	public abstract double getOverallMark();

	public abstract String getFinalGrade();

	long getId() {
	    throw new UnsupportedOperationException("Not supported yet."); 
	    //To change body of generated methods, choose Tools | Templates.
	}

	 

	String getstudentNumber() {
	    return this.studentNumber;
	}
	
	// Overload toString() method to return course work student information
	@Override
	public String toString(){
		String result = "Title: " + title +
				  "\nFirstName: " + firstName +
				  "\nLastName:" + lastName +
				  "\nStudent ID: " + studentNumber +
				  "\nBirthDay: " + birthMonth + "/" + birthDate + "/" +birthYear; 
				 
		return result; 
	}
	
	/**
	 * ToCSV format
	 * @return
	 */
	public String toCSVString(){
		String CSV_Separator = ",";
		String result = title + CSV_Separator + 
				  firstName +  CSV_Separator + 
				  lastName +  CSV_Separator + 
				  studentNumber +  CSV_Separator + 
				  birthMonth + "/" + birthDate + "/" +birthYear +  CSV_Separator ;	 
		return result; 
	}
}// End of class Student

