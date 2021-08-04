public class University {

	private ModuleDescriptor[] moduleDescriptors;
	
	private Student[] students;
	
	private Module[] modules;

	public University(){
		moduleDescriptors = createModuleDescriptors();
		StudentRecord[] records = createStudentsModules();
		Module[] moduleArray = new Module[7];
		Student[] studentArray = new Student[10];
		for (int i=0;i<7;i++){
			moduleArray[i] = records[i].getModule();
		}
		for (int i=0;i<10;i++){
			studentArray[i] = records[i].getStudent();
		}
		modules = moduleArray;
		students = studentArray;
	}

	private ModuleDescriptor[] createModuleDescriptors(){
		ModuleDescriptor[] array = new ModuleDescriptor[6];
		double[] weights1 = {0.1,0.3,0.6};
		array[0] = new ModuleDescriptor("ECM0002","Real World Mathematics",weights1,array);
		double[] weights2 = {0.25,0.25,0.25,0.25};
		array[1] = new ModuleDescriptor("ECM1400","Programming",weights2,array);
		double[] weights3 = {0.25,0.25,0.5};
		array[2] = new ModuleDescriptor("ECM1406","Data Structures",weights3,array);
		double[] weights4 = {0.2,0.3,0.5};
		array[3] = new ModuleDescriptor("ECM1410","Object-Oriented Programming",weights4,array);
		double[] weights5 = {0.1,0.3,0.3,0.3};
		array[4] = new ModuleDescriptor("BEM2027","Information Systems",weights5,array);
		double[] weights6 = {0.4,0.6};
		array[5] = new ModuleDescriptor("PHY2023","Thermal Physics",weights6,array);
		return array;
	}

	private StudentRecord[] createStudentsModules(){
		StudentRecord[] records = new StudentRecord[40];
		Module[] moduleArray = new Module[7];
		Student[] studentArray = new Student[10];
		
		studentArray[0] = new Student(1000, "Ana", 'F', records);
		studentArray[1] = new Student(1001, "Oliver", 'M', records);
		studentArray[2] = new Student(1002, "Mary", 'F', records);
		studentArray[3] = new Student(1003, "John", 'M', records);
		studentArray[4] = new Student(1004, "Noah", 'M', records);
		studentArray[5] = new Student(1005, "Chico", 'M', records);
		studentArray[6] = new Student(1006, "Maria", 'F', records);
		studentArray[7] = new Student(1007, "Mark", 'X', records);
		studentArray[8] = new Student(1008, "Lia", 'F', records);
		studentArray[9] = new Student(1009, "Rachel", 'F', records);

		byte term = 1;
		moduleArray[0] = new Module(2019, term, moduleDescriptors[1], records);
		moduleArray[1] = new Module(2019, term, moduleDescriptors[5], records);
		moduleArray[2] = new Module(2019, ++term, moduleDescriptors[4], records);
		moduleArray[3] = new Module(2019, ++term, moduleDescriptors[1], records);
		moduleArray[4] = new Module(2020, term, moduleDescriptors[2], records);
		moduleArray[5] = new Module(2020, term, moduleDescriptors[3], records);
		moduleArray[6] = new Module(2020, ++term, moduleDescriptors[0], records);

		double[] marks1 = {9,10,10,10};
		records[0] = new StudentRecord(studentArray[0], moduleArray[0], marks1);
		double[] marks2 = {8, 8, 8, 9};
		records[1] = new StudentRecord(studentArray[1], moduleArray[0], marks2);
		double[] marks3 = {5,5,6,5};
		records[2] = new StudentRecord(studentArray[2], moduleArray[0], marks3);
		double[] marks4 = {6,4,7,9};
		records[3] = new StudentRecord(studentArray[3], moduleArray[0], marks4);
		double[] marks5 = {10,9,10,9};
		records[4] = new StudentRecord(studentArray[4], moduleArray[0], marks5);

		double[] marks6 = {9 ,9};
		records[5] = new StudentRecord(studentArray[5], moduleArray[1], marks6);
		double[] marks7 = {6, 9};
		records[6] = new StudentRecord(studentArray[6], moduleArray[1], marks7);
		double[] marks8 = {5, 6};
		records[7] = new StudentRecord(studentArray[7], moduleArray[1], marks8);
		double[] marks9 = {9, 7};
		records[8] = new StudentRecord(studentArray[8], moduleArray[1], marks9);
		double[] marks10 = {8, 5};
		records[9] = new StudentRecord(studentArray[9], moduleArray[1], marks10);

		double[] marks11 = {10 ,10, 9.5, 10};
		records[10] = new StudentRecord(studentArray[0], moduleArray[2], marks11);
		double[] marks12 = {7, 8.5, 8.2, 8};
		records[11] = new StudentRecord(studentArray[1], moduleArray[2], marks12);
		double[] marks13 = {6.5,7.0,5.5,8.5};
		records[12] = new StudentRecord(studentArray[2], moduleArray[2], marks13);
		double[] marks14 = {5.5,5,6.5,7};
		records[13] = new StudentRecord(studentArray[3], moduleArray[2], marks14);
		double[] marks15 = {7,5,8,6};
		records[14] = new StudentRecord(studentArray[4], moduleArray[2], marks15);

		double[] marks16 = {9,10,10,10};
		records[15] = new StudentRecord(studentArray[5], moduleArray[3], marks16);
		double[] marks17 = {8, 8, 8, 9};
		records[16] = new StudentRecord(studentArray[6], moduleArray[3], marks17);
		double[] marks18 = {5,5,6,5};
		records[17] = new StudentRecord(studentArray[7], moduleArray[3], marks18);
		double[] marks19 = {6,4,7,9};
		records[18] = new StudentRecord(studentArray[8], moduleArray[3], marks19);
		double[] marks20 = {10,9,8,9};
		records[19] = new StudentRecord(studentArray[9], moduleArray[3], marks20);

		double[] marks21 = {10 ,10, 10};
		records[20] = new StudentRecord(studentArray[0], moduleArray[4], marks21);
		double[] marks22 = {8, 7.5, 7.5};
		records[21] = new StudentRecord(studentArray[1], moduleArray[4], marks22);
		double[] marks23 = {9,7,7};
		records[22] = new StudentRecord(studentArray[2], moduleArray[4], marks23);
		double[] marks24 = {9,8,7};
		records[23] = new StudentRecord(studentArray[3], moduleArray[4], marks24);
		double[] marks25 = {2,7,7};
		records[24] = new StudentRecord(studentArray[4], moduleArray[4], marks25);

		double[] marks26 = {10 ,10, 10};
		records[25] = new StudentRecord(studentArray[5], moduleArray[4], marks26);
		double[] marks27 = {8, 7.5, 7.5};
		records[26] = new StudentRecord(studentArray[6], moduleArray[4], marks27);
		double[] marks28 = {10,10,10};
		records[27] = new StudentRecord(studentArray[7], moduleArray[4], marks28);
		double[] marks29 = {9,8,7};
		records[28] = new StudentRecord(studentArray[8], moduleArray[4], marks29);
		double[] marks30 = {8,9,10};
		records[29] = new StudentRecord(studentArray[9], moduleArray[4], marks30);

		double[] marks31 = {10 ,9, 10};
		records[30] = new StudentRecord(studentArray[0], moduleArray[5], marks31);
		double[] marks32 = {8.5,9,7.5};
		records[31] = new StudentRecord(studentArray[1], moduleArray[5], marks32);
		double[] marks33 = {10,10,5.5};
		records[32] = new StudentRecord(studentArray[2], moduleArray[5], marks33);
		double[] marks34 = {7,7,7};
		records[33] = new StudentRecord(studentArray[3], moduleArray[5], marks34);
		double[] marks35 = {5,6,10};
		records[34] = new StudentRecord(studentArray[4], moduleArray[5], marks35);

		double[] marks36 = {8 ,9, 8};
		records[35] = new StudentRecord(studentArray[5], moduleArray[6], marks36);
		double[] marks37 = {6.5,9,9.5};
		records[36] = new StudentRecord(studentArray[6], moduleArray[6], marks37);
		double[] marks38 = {8.5,10,8.5};
		records[37] = new StudentRecord(studentArray[7], moduleArray[6], marks38);
		double[] marks39 = {7.5,8,10};
		records[38] = new StudentRecord(studentArray[8], moduleArray[6], marks39);
		double[] marks40 = {10, 6, 10};
		records[39] = new StudentRecord(studentArray[9], moduleArray[6], marks40);
		return records;
	}	

	/**
	 * @return The number of students registered in the system.
	 */
	public int getTotalNumberStudents() {
		return students.length;
	}

	/**
	 * @return The student with the highest GPA.
	 */
	public Student getBestStudent() {
		double highest = students[0].getGpa();
		int studentNumber = 0;
		for (int i=1;i<getTotalNumberStudents();i++){
			if (students[i].getGpa() > highest){
				highest = students[i].getGpa();
				studentNumber = i;
			}
		}
		return students[studentNumber];
	}

	/**
	 * @return The module with the highest average score.
	 */
	public Module getBestModule() {
		double highest = modules[0].getFinalAverageGrade();
		int moduleNumber = 0;
		for (int i=1;i<modules.length;i++){
			if (modules[i].getFinalAverageGrade() > highest){
				highest = modules[i].getFinalAverageGrade();
				moduleNumber = i;
			}
		}
		return modules[moduleNumber];
	}
	
	public static void main(String[] args) {
		University uok = new University();
		System.out.println("The number of students are: "+uok.getTotalNumberStudents());
		System.out.println("The best module score is: "+uok.getBestModule().getFinalAverageGrade());
		System.out.println("The best student is: "+uok.getBestStudent().printTranscript());
	}
}
