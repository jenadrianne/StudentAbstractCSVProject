package studentAbstract;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClientMainClass {

	private List<Student> studentList = new ArrayList<>();
	public static Scanner scanners = new Scanner(System.in); 
	public static boolean isSorted = false;
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String [] args) {
		ClientMainClass sr = new ClientMainClass();
		int option = 0;
				
		//load students from student.txt
	    sr.loadStudents();
	     
		//Show the menu    
	     try {
			do {
				option = sr.showMenu(); 
			    switch(option) {
			    	case 1:
			    		  System.exit(0);
			    		  break;
			        case 2:
			              sr.loadCourseWorkStudentMarks();
			              sr.loadResearchStudentMarks();
			              break; 
			       case 3:
			    	      System.out.println("\nEnter Student id to delete: "); 
			    	      String studentid = scanners.next();
			    	   	  sr.deleteStudentRecord(studentid);
			    	   	  break;
			       case 4:
			    	      sr.printStudentRecords();
			    	      break;
			       case 5:
			    	     sr.computeAndOutputOverAllMark();
			    	     break;
			       case 6:
			    	   	 sr.calculateStudentAvegarge();
			    	     break;
			       case 7:
			    	      System.out.print("\n Enter Student ID to search: ");
				          String id = scanners.next();
				          sr.printStudentRecords(id);
			    	      break;
			       
			       case 8:
				          System.out.print("\n Enter student's Last name to search: ");
				          String lastName = scanners.next();
				          System.out.print("\n Enter student's First name to search: ");
				          String firstName = scanners.next();
				          sr.printStudentRecords(firstName, lastName);
				          break;
			       case 9 : 
			    	   	  isSorted = sr.sortRecords();
			    	   	  break; 
			       case 10: 
			    	   	  if(isSorted) {
			    	   		  sr.writeToCsv();
			    	   	  }else {
			    	   		  System.out.println("Please Sort Array first"); 
			    	   	  }
			    	   	  break;
			       default:
			    	   	   System.out.print("\n Invalid choice!!");
			    }
			 }while(option != 1);
		} catch (Exception e) {
			System.out.println("Invalid input. Terminating the program....");
		}  
	     
	     scanners.close();
	  }
	
	 /**
	  * Show menu options
	  * @return
	  */
	  public static  int showMenu()
	  {
		 int option = 0; 
	     System.out.print("\n\n ************** MENU ************** ");
	     System.out.print("\n\t 1 - Quit "
	     					+ "\n\t 2 - Add CourseWork or Research Information"
	     					+ "\n\t 3 - Remove Student" 
	     					+ "\n\t 4 - Show All Student Information "
	     					+ "\n\t 5 - Compute Student Grades"
	     					+ "\n\t 6 - Students Below or Above average" 
	     					+ "\n\t 7 - Search Student by ID "
	     					+ "\n\t 8 - Search Student by name"
	     					+ "\n\t 9 - Sort Student by ID"
	     					+ "\n\t 10 - Output Sorted Array"
	     					+ "\n\n What is your choice? ");
	     option = scanners.nextInt();
	     return option; 
	  }
	  
	  /**
	   * Load basic student information
	   */
	   public void loadStudents() {
	       try {
	           InputStream inputStream = new FileInputStream("./src/student.txt");
	           int counter = 0;
	
	           BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
	           for (String line; (line = br.readLine()) != null; counter++) {
	               String[] studentInfo = line.split(" ");
	         
	               String title = studentInfo[0]; 
	               String firstName = studentInfo[1];
	               String lastName = studentInfo[2];
	               String studentNumber = studentInfo[3];
	               int birthDate =Integer.parseInt(studentInfo[4]);
	               int birthMonth =Integer.parseInt(studentInfo[5]);
	               int birthYear = Integer.parseInt(studentInfo[6]);
	               
	               Student student = new  CourseWorkStudent(title, firstName, lastName, studentNumber, 
	            		   					birthDate, birthMonth, birthYear, 0.0, 0.0, 0.0, 0.0);
	
	               studentList.add(student);
	           }
	
	       } catch (IOException e) {
	    	   e.printStackTrace();
	    	}
	
	   }
	   
	   /**
	    * Get the position of the student in the list
	    */
	   public int getIndexByStudentId(String id) {
	       int index = -1;
	       for (Student student : studentList) {
	           index++;
	           if (student.getstudentNumber().equals(id)) {
	               return index;
	           }

	       }
	       //student not found
	       return -1;
	   }
	   
	   /**
	    * Load course work student
	    */
	   public void loadCourseWorkStudentMarks() {
		   try {
			   InputStream inputStream = new FileInputStream("./src/courseWorkStudent.txt");

	           int counter = 0;

	           BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

	           for (String line; (line = br.readLine()) != null; counter++) {
	        	   String[] studentMarks = line.split(" ");
	        	   int index = getIndexByStudentId(studentMarks[0]);
	        	   
	        	   if (index >= 0) {
	        		   Student stud = studentList.get(index);
	        		   double ass1  = Double.valueOf(studentMarks[1]);
	                   double ass2  = Double.valueOf(studentMarks[2]);
	                   double prac = Double.valueOf(studentMarks[3]);
	                   double finalex = Double.valueOf(studentMarks[4]);
	                   CourseWorkStudent courseWorkStudent = new  CourseWorkStudent(stud.getTitle(), stud.getFirstName(), stud.getLastName(),
	                		   stud.getstudentNumber(), stud.getBirthDate(), stud.getBirthMonth(), stud.getBirthYear(), ass1, ass2, prac, finalex);
	                   
	                   studentList.set(index, courseWorkStudent);
	               }

	           }

	       } catch (IOException e) {
	           e.printStackTrace();
	       }

	   }

	 
	   /**
	    * Load Research student
	    */
	   public void loadResearchStudentMarks() {
	       try {
	           InputStream inputStream = new FileInputStream("./src/researchStudent.txt");
	           int counter = 0;

	           BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

	           for (String line; (line = br.readLine()) != null; counter++) {
	               String[] studentMarks = line.split(" ");
	               int index = getIndexByStudentId(studentMarks[0]);

	               if (index >= 0) {
	            	   Student stud = studentList.get(index);
	        		   double FinalOralPPT  = Double.valueOf(studentMarks[1]);
	                   double FinalThesis  = Double.valueOf(studentMarks[2]);
	               
	                   ResearchStudent researchStudent = new ResearchStudent(stud.getTitle(), stud.getFirstName(), stud.getLastName(), 
	                		   stud.getstudentNumber(), stud.getBirthDate(), stud.getBirthMonth(), stud.getBirthYear(), FinalOralPPT, FinalThesis);

	                   studentList.set(index, researchStudent);
	               }
	           }

	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	   
	   /**
	    * Print all student records
	    */
	   public void printStudentRecords() {
		   for(Student stud : studentList) {
			   System.out.println(stud.toString()); 
			   System.out.println("\n-----------------\n");
		   }
	   }
	   
	   /**
	    * Print all student records by Student ID 
	    */
	   public void printStudentRecords(String studID) {
		   boolean found = false; 
		   for(Student stud : studentList) {
			   if(stud.getstudentNumber().equals(studID)) {
				   System.out.println(stud.toString()); 
				   found = true; 
				   break;
			   }
		   }
		   if(!found) {
			   System.out.println("Student ID "+ studID + " does not exist!");
		   }
	   }
	   
	   /**
	    * Print student records by first name and lastname
	    * @param firstname
	    * @param lastname
	    */
	   public void printStudentRecords(String firstname, String lastname) {
		   boolean found = false; 
		   for(Student stud : studentList) {
			   if(stud.getFirstName().equalsIgnoreCase(firstname) &&  stud.getLastName().equalsIgnoreCase(lastname)) {
				   System.out.println(stud.toString()); 
				   found = true; 
				   break;
			   }
		   }
		   if(!found) {
			   System.out.println("Student "+ firstname + "  " + lastname + " does not exist!");
		   }
	   }
	   
	   
	   /**
	    * Delete student record by ID
	    * @param studentID
	    */
	   public void deleteStudentRecord(String studentID) {
		   int index = getIndexByStudentId(studentID);
           if (index >= 0) {
        	   Student stud = studentList.get(index);
        	   studentList.remove(index);
        	   
        	   System.out.println("\nSuccessfully removed: \n" + stud);
           }
	   }
	   
	   /**
	    * Compute Overall mark of students
	    * @param isCourseWork
	    */
	   public void computeAndOutputOverAllMark() {
	       for (Student student : studentList) {
	           if (student instanceof CourseWorkStudent) {
	        	   ((CourseWorkStudent) student).calculate();
	               System.out.println(student.getstudentNumber() + " " + student.getTitle() + " " + student.getFirstName() + " " + student.getLastName() + " " + ((CourseWorkStudent) student).getOverallMark() + " " + ((CourseWorkStudent) student).getFinalGrade());
	           } else if (student instanceof ResearchStudent) {
	        	   ((ResearchStudent) student).calculate();
	               System.out.println(student.getstudentNumber() + " " + student.getTitle() + " " + student.getFirstName() + " " + student.getLastName() + " " + ((ResearchStudent) student).getOverallMark() + " " + ((ResearchStudent) student).getFinalGrade());
	           }
	       }

	   }
	   
	   /**
	    * Calculate above and below the average
	    */
	   public void calculateStudentAvegarge() {
	       double grades = 0;
	       int totalStudent = 0;

	       for (Student student : studentList) {
	    	   if (student instanceof CourseWorkStudent) {
	               grades += ((CourseWorkStudent) student).getOverallMark();
	               totalStudent++;
	           } else if (student instanceof ResearchStudent) {
	               grades += ((ResearchStudent) student).getOverallMark();
	               totalStudent++;
	           }

	       }

	 
	       double averageGrade = grades / totalStudent;
	       int belowAverage = 0;
	       int equalOrAboveAverage = 0;

	       for (Student student : studentList) {
	           if (student instanceof CourseWorkStudent) {
	               if (((CourseWorkStudent) student).getOverallMark() >= averageGrade) {
	                   equalOrAboveAverage++;
	               } else {
	                   belowAverage++;
	               }

	           } else if (student instanceof ResearchStudent) {
	               if (((ResearchStudent) student).getOverallMark() >= averageGrade) {
	                   equalOrAboveAverage++;
	               } else {
	                   belowAverage++;
	               }

	           }

	       }
	       System.out.println("Average Grade is : " + averageGrade);
	       System.out.println(equalOrAboveAverage + " students scored equal or above the average and " + belowAverage + " students fall below the average.");
	   }
	   
	   /**
	    * Sort Records
	    */
	   public boolean sortRecords() {
	       Student[] studentArray = studentList.toArray(new Student[0]);
	       
	       try {
			mergeSort(studentArray, studentArray.length);
			   
			   studentList = Arrays.asList(studentArray);
			   
			   System.out.println("New sorted array: ");
			   
			   printStudentRecords();  
			   
			   return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	   }

	 
	   /**
	    * Merge Sort
	    * @param studentsArr
	    * @param length
	    */
	   public static void mergeSort(Student[] studentsArr, int length) {
	       if (length < 2) {
	           return;
	       }

	       int mid = length / 2;
	       Student[] left = new Student[mid];
	       Student[] right = new Student[length - mid];

	       for (int i = 0; i < mid; i++) {
	           left[i] = studentsArr[i];
	       }

	       for (int i = mid; i < length; i++) {
	           right[i - mid] = studentsArr[i];
	       }

	       //split and sort
	       mergeSort(left, mid);
	       mergeSort(right, length - mid);

	       //merge
	       int i = 0, j = 0, k = 0;
	       while (i < mid && j < length - mid) {
	    	   int leftId = Integer.parseInt(left[i].getstudentNumber());
	    	   int rightId = Integer.parseInt(right[j].getstudentNumber());
	           if (leftId <= rightId) {
	               studentsArr[k++] = left[i++];
	           } else {
	               studentsArr[k++] = right[j++];
	           }
	       }

	       while (i < mid) {
	           studentsArr[k++] = left[i++];
	       }

	       while (j < length - mid) {
	           studentsArr[k++] = right[j++];
	       }
	   }

	 
	   /**
	    * Write to CSV;
	    */
	   public void writeToCsv() {
	       try (PrintWriter writer = new PrintWriter("./src/output.csv")) {
	    	   StringBuilder sb = new StringBuilder();
	    	   String CSV_SEPARATOR = ",";
	 

	    	   //header
	    	   sb.append("ID" + CSV_SEPARATOR);
	    	   sb.append("Title" + CSV_SEPARATOR);
	    	   sb.append("First Name" + CSV_SEPARATOR);
	    	   sb.append("Last Name" + CSV_SEPARATOR);
	    	   sb.append("Birthday" + CSV_SEPARATOR);
	    	   sb.append("Assignment 1" + CSV_SEPARATOR);
	    	   sb.append("Assignment 2" + CSV_SEPARATOR);
	    	   sb.append("Practical" + CSV_SEPARATOR);
	    	   sb.append("Final Examination" + CSV_SEPARATOR);
	    	   sb.append("Oral Presentation" + CSV_SEPARATOR);
	    	   sb.append("Final Thesis" + CSV_SEPARATOR);
	    	   sb.append("Weighted Average" + CSV_SEPARATOR);
	    	   sb.append("Final Grade" + CSV_SEPARATOR);
	           sb.append("\n");
	           
	           for (Student student : studentList) {
	        	   sb.append(student.toCSVString());
	        	   sb.append("\n");
	           }
	           
	           writer.write(sb.toString());

	           System.out.println("Done writing to CSV!");

	       } catch (FileNotFoundException e) {
	           System.out.println("Error saving into file!" + e.getMessage());
	       }
	   }
}
