import java.util.HashMap;

public class SpreadingNews {
     public int minTime(int[] supervisors) {
    	 Node myRoot = new Node(0, null);
    	 HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    	 map.put(0, myRoot);
    	 
    	 // add all employees to tree
    	 for(Integer i=1; i<supervisors.length; i++){
    		 Node boss = map.get(supervisors[i]);
    		 Node newNode = new Node(i, boss);
    		 boss.add(newNode);
    		 map.put(i, newNode);
    	 }
    	 
    	 int minutes = 0; 
    	 boolean[] called = new boolean[supervisors.length]; 
    	 called[0] = true; 
    	 for(int i=1; i<supervisors.length; i++){
    		 called[i] = false; 
    	 }
    	 boolean allCalled = false;
    	 
    	 
    	 // go through map
    	 while(!allCalled & minutes<supervisors.length){
    		 for(Integer i: map.keySet()){
    			 if(called[i]){
    				 Node boss = map.get(i); // anyone who has been called so far
        			 int max2away = -1; 
        			 int idMax=-1;
        			 for(Integer empid : boss.myMap.keySet()){
        				 Node tmp = boss.myMap.get(empid);
        				 if(!called[empid]){
        					 int num2away = tmp.myMap.size();
            				 if(num2away > max2away){ idMax = empid; }
        				 }
        			 }
        			 // boss calls employee with most subordinates
        			 if(idMax > 0){
        				 Node one2call = boss.myMap.get(idMax);
        				 one2call.isCalled = true; 
        				 called[idMax] = true; 
        			 }
    			 }
    			 
    		 }
    		 allCalled = checkCalled(called);
    		 minutes++; 
    	 }
    	 // for a node for which index < calls+1:
    	 // look at its children
    	 // whichever one has most employees it calls first
    	 // everyone who has been called can make calls
    	 
    	 return minutes; 
     }
     
     public boolean checkCalled(boolean[] called){
    	 for(int i=0; i<called.length; i++){
    		 if(called[i]==false){ 
//    			 System.out.println(i);
    			 return false;
    		 }
    	 }
    	 return true; 
     }
     
     
     public class Node{
    	 Integer myData;
    	 boolean isCalled;
    	 Node myBoss;
    	 HashMap<Integer, Node> myMap = new HashMap<Integer, Node>();
    	 
    	 public Node(Integer data, Node boss){
    		 myData = data;
    		 isCalled = false;
    		 myBoss = boss; 
    	 }
    	 
    	 public void add(Node n){
    		 myMap.put(n.myData, n);
    	 }
     }
     
     public static void main(String[] args){
    	 SpreadingNews sn = new SpreadingNews();
    	 int[] test1 = {-1, 0, 0};
    	 int result1 = sn.minTime(test1);
    	 System.out.println(result1);
    	 
    	 int[] test2 = {-1, 0, 0, 2, 2};
    	 int result2 = sn.minTime(test2);
    	 System.out.println(result2);
     }

}
