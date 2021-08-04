import java.lang.System;

public class Student {
	
	private int id = 0;
	
	private String name = "";
	
	private char gender = ' ';
	
	private double gpa;
	
	private StudentRecord[] records;

	public Student(int id, String name, Character gender, StudentRecord[] records){
		char genderUpper = Character.toUpperCase(gender);
		this.id = id;
		this.name = name;
		this.gender = genderUpper;
		this.records = records;
		gpa = calcGpa();
		
		checkGender();
		checkIdUnique();
		}

	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public char getGender(){
		return gender;
	}

	public double getGpa(){
		return gpa;
	}

	public StudentRecord[] getRecord(){
		return records;
	}

	private void checkIdUnique(){
		for (int i = 0;i<records.length;i++){
			if (id == records[i].getStudent().getId()){
				System.out.println("Error - Id is not unique.");
				System.exit(0);
			}
		}
	}

	private void checkGender(){
		if (gender != 'F'&& gender != 'M'&& gender != 'X'&& gender != ' '){
			System.out.println("Error - Gender is not blank, X, M or F.");
			System.exit(0);
		}
	}

	private double calcGpa(){
		double sum = 0;
		for (int i=0;i<records.length;i++){
			sum += records[i].getFinalScore();
		}
		return sum / records.length;
	}

	public String printTranscript() {
		String transcript = "\n\nID: "+id+"\nName: "+name+"\nGPA: "+gpa+"\n";
		byte prevTerm = records[0].getModule().getTerm();
		for (int i=0;i<records.length;i++){
			int year = records[i].getModule().getYear();
			byte term = records[i].getModule().getTerm();
			String code = records[i].getModule().getModuleDescriptor().getCode();
			double score = records[i].getFinalScore();
			transcript = transcript.concat("|"+year+"|"+term+"|"+code+"|"+score+"\n");
			if (prevTerm != term){
				transcript = transcript.concat("\n");
			}
			prevTerm = term;
		}
		return transcript;
	}


}
