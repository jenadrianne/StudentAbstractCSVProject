package studentAbstract;

public class ResearchStudent extends Student {

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
