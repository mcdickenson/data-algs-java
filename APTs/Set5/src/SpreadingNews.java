import java.util.HashMap;

public class SpreadingNews {
	public int minTime(int[] supervisors) {
   	 
		int minutes=0;
		int CONSTANT = 192;
		HashMap<String, String> relationships = new HashMap<String, String>();
		String called = Character.toString((char) CONSTANT);
		String hasBeenCalled = called; 
		
		for(int i=1; i<supervisors.length; i++){
			String bString = Character.toString((char) (supervisors[i]+CONSTANT));
			String eString = Character.toString((char) (i+CONSTANT));
			// if it's already in there, get current string, append this one, put back
			if(relationships.containsKey(bString)){
				String current = relationships.get(bString);
				current = current + eString;
				relationships.put(bString, current);
			}
			// if not already in there, put this one in
			else{
				relationships.put(bString, eString);
			}
		}

		while(called.length()<supervisors.length & minutes<supervisors.length){
		
			//iterate over relationships.keySet
			for(String key: relationships.keySet()){

				if(hasBeenCalled.contains(key)){ //if that person has been called
					String values = relationships.get(key);
					//find which of their mapped values has the most values mapped to it
					int max = -1;
					int howManySubords;
					String hasMost = "";
					for(int j=0; j<values.length(); j++){
						String employee = values.substring(j,j+1);
						howManySubords = checkDepth(employee, relationships);
						if(howManySubords>max){ 
							max = howManySubords;
							hasMost = employee; 
						}
					}
		
					// remove hasMost from values
					if(!(hasMost.equals(""))){
						values = values.replaceAll(hasMost, "");
						relationships.put(key, values);
					}

					// add hasMost to called
					called = called + hasMost; 
					
				}
			}
			minutes++;
			hasBeenCalled = called;
		}

		return minutes; 
    }
	
	public int checkDepth(String e, HashMap<String, String> r){
		int depth;
		if(r.containsKey(e)){
			String subords = r.get(e);
			depth = subords.length();
			for(int i=0; i<subords.length(); i++){
				String tmp = subords.substring(i, i+1);
				depth += checkDepth(tmp, r);
			}
		}
		else{ depth=0; }
		return depth;
	}
	

//     public static void main(String[] args){
//    	 SpreadingNews sn = new SpreadingNews();
//    	 int[] test1 = {-1, 0, 0};
//    	 int result1 = sn.minTime(test1);
//    	 System.out.println(result1);
//    	 
//    	 int[] test2 = {-1, 0, 0, 2, 2};
//    	 int result2 = sn.minTime(test2);
//    	 System.out.println(result2);
//     }

}
