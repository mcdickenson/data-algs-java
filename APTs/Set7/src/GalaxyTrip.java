import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class GalaxyTrip {
	public int[] possibleValues(String[] dependencies){
		Graph graph = new Graph(dependencies);
		TreeMap<String, List<String>> g = graph.myGraph; 
		for(String k: g.keySet()){
			System.out.print(k+" ");
			System.out.println(g.get(k));
		}

//		// turn g into a list/map of sizes 	   		
		HashMap<String, Integer> graphSizes = sumSizes(g);

		int[] sizes = new int[graphSizes.keySet().size()];
		int j=0;
		for(String key : graphSizes.keySet()){
			int s = graphSizes.get(key);
//			System.out.print(key + " ");
//			System.out.println(s);
			sizes[j] = s;
			j++;
		}

		TreeSet<Integer> sums = sumArray(sizes);

		int[] result = new int[sums.size()];
		int i=0;
		for(int s: sums){
			result[i] = s;
			i++;
			// 		   System.out.println(s);
		}

		return result; 
    }
	
	public HashMap<String, Integer> sumSizes(TreeMap<String, List<String>> g){
		// map visited nodes to their parent (or -1)
		HashMap<String, String> visited = new HashMap<String, String>();
		// map parents to the size of their graph
		HashMap<String, Integer> graphSizes = new HashMap<String, Integer>();

		for(String k : g.keySet()){
			List<String> neighbors = g.get(k);
			//			System.out.println(s);
			if(!visited.containsKey(k)){
				int numConnections = 1;
				for(String n: neighbors){
					visited.put(n, k);
					numConnections++;
				}
				graphSizes.put(k, numConnections);
			}
//			else{
//				String parent = visited.get(k);		
//				while(!graphSizes.containsKey(parent)){
//					parent = visited.get(parent);
//				}
//				int parentSize = graphSizes.get(parent);
//				for(String n: neighbors){
//					if(!visited.containsKey(n)){
//						visited.put(n, k);
//						parentSize++;
//					}
//				}
//				graphSizes.put(parent, parentSize);
//			}

		}
		return graphSizes;
	}
	
	public class Graph{	
		TreeMap<String, List<String>> myGraph = new TreeMap<String, List<String>>();
		
		public Graph(String[] dependencies){
			int vertex = 0;
			for(String s : dependencies)
			{
				String sv = "" + vertex;
				vertex++;
				List<String> list = new ArrayList<String>();	
				if (s.equals("")){ // singleton
					myGraph.put(sv, list);
					continue;
				}
				String[] a = s.split(" ");

				for (String nextv : a){
					list.add(nextv);
				}

				myGraph.put(sv, list);
			}
		}
		
	}
    
	public TreeSet<Integer> sumArray(int[] sizes){
		TreeSet<Integer> counts = new TreeSet<Integer>();
		
		// loop through possible windows
		for(int window=1; window<=sizes.length; window++){
			// loop through sizes
			for(int i=0; i<sizes.length-window+1; i++){
				int thisWindow = 0;
				for(int j=i; j<i+window; j++){
					thisWindow += sizes[j];
				}
				counts.add(thisWindow);
			}
		}
		
		return counts;
	}
       
	public static void main(String[] args){
		GalaxyTrip gt = new GalaxyTrip();

		String[] d1 = {"1 2", "0", "0", ""};
		int[] test1 = {1, 3, 4};
		int[] result1 = gt.possibleValues(d1);
		if(test1.length==result1.length){ System.out.println("test 1 passes");}
		else{System.out.println("test 1 fails");}
		
		String[] d2 = {"7", "10 4", "4", "6 8", "2 1", "10 9", "3", "0", "11 3", "12 5", "1 5", "8", "9 13", "12"};
		int[] test2 = {2, 4, 6, 8, 10, 12, 14};
		int[] result2 = gt.possibleValues(d2);
		if(test2.length==result2.length){ System.out.println("test 2 passes");}
		else{System.out.println("test 2 fails");}
	}
}
