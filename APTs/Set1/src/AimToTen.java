public class AimToTen {
    public int need(int[] marks) {
    	int sumOfGrades = 0;
    	for(int mark : marks){
    		sumOfGrades += mark; 
    	}
    	double averageGrade = sumOfGrades / marks.length; 
    	
    	int classesNeeded = 0;
    	while(averageGrade < 9.5){
    		classesNeeded += 1;
    		sumOfGrades += 10;
    		averageGrade = sumOfGrades / (marks.length + classesNeeded);
    	}
    	
    	return classesNeeded;
    }
  }
