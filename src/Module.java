public class Module {
	
	private int year;
	
	private byte term;
	
	private ModuleDescriptor module;
	
	private StudentRecord[] records;
	
	private double finalAverageGrade;

	public Module(int year, byte term, ModuleDescriptor module, StudentRecord[] records){
		this.year = year;
		this.term = term;
		this.module = module;
		this.records = records;
		this.finalAverageGrade = calcAverageGrade();
	}

	public int getYear(){
		return year;
	}

	public byte getTerm(){
		return term;
	}

	public ModuleDescriptor getModuleDescriptor(){
		return module;
	}

	public StudentRecord[] getRecord(){
		return records;
	}

	public double getFinalAverageGrade(){
		return finalAverageGrade;
	}

	private double calcAverageGrade(){
		double sum = 0;
		for (int i=0;i<records.length;i++){
			sum += records[i].getFinalScore();
		}
		return sum / records.length;
	}
	
}
