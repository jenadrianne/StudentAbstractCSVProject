package studentAbstract;

public class CourseWorkStudent extends Student {
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

