public class StudentRecord {

	private Student student;
	
	private Module module;
	
	private double[] marks;
	
	private double finalScore;
	
	private boolean isAboveAverage;
	
	public StudentRecord
	(Student student, Module module, double[] marks){
		this.student = student;
		this.module = module;
		this.marks = marks;
		finalScore = calcFinalScore();
		isAboveAverage = calcAboveAverage();
		checkRange(finalScore);
		for (int i=0;i<marks.length;i++){
			checkRange(marks[i]);
		}
	}

	public Student getStudent(){
		return student;
	}

	public Module getModule(){
		return module;
	}

	public double[] getMarks(){
		return marks;
	}

	public double getFinalScore(){
		return finalScore;
	}

	public boolean getIsAboveAverage(){
		return isAboveAverage;
	}

	private void checkRange(double value){
		if (value < 0 || value > 100){
			System.out.println("Error - score or marks out of range (between 0 and 100)");
			System.exit(0);
		}
	}

	private double calcFinalScore(){
		double product = 0.0;
		int length = marks.length;
		for (int i = 0;i<length;i++){
			product += marks[i]*module.getFinalAverageGrade();
		}
		return product/length;
	}

	private boolean calcAboveAverage(){
		double sum = 0.0;
		int numberStudents = student.getRecord().length;
		for (int i=0;i<numberStudents;i++){
			sum += student.getRecord()[i].finalScore;
		}
		double average = sum/numberStudents;
		if (finalScore > average){
			return true;
		}
		return false;
	}
}