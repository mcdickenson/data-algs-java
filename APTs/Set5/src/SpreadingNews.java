public class SpreadingNews {
     public int minTime(int[] supervisors) {
    	 
    	 String q = "";
    	 for(int i=1; i<supervisors.length; i++){
    		 q += Character.toString((char) (supervisors[i]+65));
    	 }
//    	 System.out.println(q);
    	 
    	 int calls = 0;
    	 while(calls<supervisors.length && q.length()>0 ){
    		 for(int i=0; i<calls+1; i++){
    			 String remove = Character.toString((char) (i+65));
    			 q = q.replaceFirst(remove, "");
    		 }
    		 calls++;
//    		 System.out.println(q);
    	 }
    	 
    	 
    	 return calls; 
     }
     
//     public static void main(String[] args){
//    	 SpreadingNews sn = new SpreadingNews();
//    	 int[] test1 = {-1, 0, 0};
//    	 int result1 = sn.minTime(test1);
//    	 System.out.println(result1);
//    	 
//    	 int[] test2 = {-1, 0, 0, 2, 2};
//    	 
//     }

}
