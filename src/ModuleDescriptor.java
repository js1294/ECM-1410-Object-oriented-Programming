public class ModuleDescriptor {
	
	private String code = "";
	
	private String name = "";
	
	private double[] continuousAssignmentWeights;

	public ModuleDescriptor(String code,String name,double[] weights, ModuleDescriptor[] moduleDescriptors){
		this.code = code;
		this.name = name;
		continuousAssignmentWeights = weights;
		checkWeights();
		checkCodeUnique(moduleDescriptors);
	}

	public String getCode(){
		return code;
	}

	public String getName(){
		return name;
	}

	public double[] getContinuousAssignmentWeights(){
		return continuousAssignmentWeights;
	}

	private void checkCodeUnique(ModuleDescriptor[] moduleDescriptors){
		final int length = moduleDescriptors.length;
		for (int i=1;i<length;i++){
			if (moduleDescriptors[i].getCode().equals(code)){
				System.out.println("Error - Code entered is not unique.");
				System.exit(0);
			}
		}
	}

	private void checkWeights(){
		double sum = 0;
		final int length = continuousAssignmentWeights.length;
		for (int i=0;i<length;i++){
			if (continuousAssignmentWeights[i] < 0){
				System.out.println("Error - negative weight in controlled assessment.");
				System.exit(0);
			}
			sum += continuousAssignmentWeights[i];
		}
		if (sum != 1.0){
			System.out.println("Error - weights do not sum to 1 in controlled assessment.");
			System.exit(0);
		}
	}
}
