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


class CourseWorkStudent extends Student {
	// Instance variable to store
	double Assign1, Assign2;
	double Practicals;
	double FinalExam;
	double OverallMarks;
	String FinalGrade;

	// Default constructor to assign default values to instance variables
	CourseWorkStudent() {
		// Calls the base class default constructor
		super();
		Assign1 = Assign2 = Practicals = FinalExam = OverallMarks = 0.0;
		FinalGrade = "";
	}

	 

	// Parameterized constructor to assign parameter values to instance variables
	CourseWorkStudent(String title, String firstName, String lastName, String studentNumber, int birthDate, int birthMonth, int birthYear, double as1, double as2, double pw, double fe)
	{
		// Calls the base class parameterized constructor
		super(title, firstName,lastName, studentNumber, birthDate, birthMonth, birthYear);
		Assign1 = as1;
		Assign2 = as2;
		Practicals = pw;
		FinalExam = fe;
		OverallMarks = 0.0;
		FinalGrade = "";
	}

	// Method to calculate weighted average and FinalGrade

	void calculate() {
		OverallMarks = 0.0;
		OverallMarks += (Assign1 * 0.25) + (Assign2 * 0.25);
		OverallMarks += Practicals * 0.20;
		OverallMarks += FinalExam * 0.30;

		if(OverallMarks >= 80.0)
			FinalGrade = "HD";
		else if(OverallMarks >= 70.0)
			FinalGrade = "D";
		else if(OverallMarks >= 60.0)
			FinalGrade = "C";
		else if(OverallMarks >= 50.0)
			FinalGrade = "P";
		else
			FinalGrade = "F";
	}

	double getWeightedAverage(){
		return OverallMarks;
	}

	// Overload toString() method to return course work student information
	@Override
	public String toString(){
		String result = super.toString();
		result += "\nAssignment1: " + Assign1 +
				  "\nAssignment2: " + Assign2 +
				  "\nPracticals:" + Practicals +
				  "\nFinal Exam: " + FinalExam +
				  "\nOverall Marks: " + OverallMarks + 
				  "\nFinalGrade: " + FinalGrade;
		return result; 
	}
	
	/**
	 * To CSV Format
	 */
	public String toCSVString(){
		String CSV_separator = ",";
		String result = super.toCSVString();
		result +=  Assign1 + CSV_separator +
				   Assign2 + CSV_separator +
				   Practicals + CSV_separator +
				   FinalExam + CSV_separator +
				   OverallMarks + CSV_separator +
				   FinalGrade;
		return result; 
	}

	@Override
	public double getOverallMark() {
		return OverallMarks ;
	}

	@Override
	public String getFinalGrade() {
		return FinalGrade;
	}
	
	
	String getstudentNumber() {
		return super.getstudentNumber();
	}

}// End of class CourseWorkStudent

class ResearchStudent extends Student {

	// Instance variable to store marks
	double FinalOralPPT;
	double FinalThesis;
	double OverallMarks;
	String FinalGrade;

	// Default constructor to assign default values to instance variables
	ResearchStudent()
	{
		// Calls the base class default constructor
		super();
		FinalOralPPT = FinalThesis = OverallMarks = 0.0;
		FinalGrade = "";
	}

	 
	// Parameterized constructor to assign parameter values to instance variables
	ResearchStudent(String title, String firstName, String lastName, String studentNumber, int birthDate, int birthMonth, int birthYear, double op, double ft)
	{
		// Calls the base class parameterized constructor
		super(title, firstName, lastName, studentNumber,birthDate, birthMonth, birthYear);
		FinalOralPPT = op;
		FinalThesis = ft;
		OverallMarks = 0;
		FinalGrade = "";
	}

	// Method to calculate weighted average and FinalGrade
	void calculate()
	{
		OverallMarks = 0.0;
		OverallMarks += FinalOralPPT * 0.20;
		OverallMarks += FinalThesis * 0.80;
		
		if(OverallMarks >= 80.0)
			FinalGrade = "HD";
		else if(OverallMarks >= 70.0)
			FinalGrade = "D";
		else if(OverallMarks >= 60.0)
			FinalGrade = "C";
		else if(OverallMarks >= 50.0)
			FinalGrade = "P";
		else
			FinalGrade = "C";
	}

	double getWeightedAverage()
	{
		return OverallMarks;
	}

	// Overload toString() method to return research student information
	@Override
	public String toString(){
		String result = super.toString();
		result += "\nFinalOralPPT: " + FinalOralPPT +
					"\nFinalThesis: "+ FinalThesis +
					"\nOverallMarks: " + OverallMarks + 
					"\nGrade: " + FinalGrade;
		return result; 
	}
	
	/**
	 * To CSV format
	 */
	public String toCSVString() {	
	 	String CSV_SEPARATOR = ",";
		String result = super.toCSVString(); 
		result +=  CSV_SEPARATOR
		          + CSV_SEPARATOR
		          + CSV_SEPARATOR
		          + CSV_SEPARATOR+
		          + FinalOralPPT + CSV_SEPARATOR
		          + FinalThesis + CSV_SEPARATOR
		          + OverallMarks + CSV_SEPARATOR
		          + FinalGrade + CSV_SEPARATOR ;
		return result; 
	}
	
	@Override
	public double getOverallMark() {
		return this.OverallMarks;
	}

	@Override
	public String getFinalGrade() {
		return this.FinalGrade;
	}

	String getstudentNumber() {
		return super.getstudentNumber();
	}

}

