import java.util.*;


public class FriendScore {
      public int highestScore(String[] friends) {
         
    	 // make list of People 
    	 int pplCount = friends.length; 
         Person[] ppl = new Person[pplCount]; 
         for(int i=0; i<pplCount; i++){
        	 ppl[i] = new Person(i); 
//        	 System.out.println(ppl[i]);
         }
         
         // add everyones' friends
         for(int i=0; i<pplCount; i++){
        	 String row = friends[i];
        	 for(int j=i+1; j<row.length(); j++){
        		 char isFriend = row.charAt(j);
        		 if(isFriend=='Y'){
        			 (ppl[i]).addFriend(ppl[j]);
        			 (ppl[j]).addFriend(ppl[i]); // reciprocal 
        		 }
        	 }
        	 ppl[i].countFriends();
//        	 System.out.println(ppl[i]);
         }
         
         for(int i=0; i<pplCount; i++){
        	 ppl[i].addTwoFriends();
        	 ppl[i].countTwoFriends();
//        	 System.out.println(ppl[i]);
         }
         
         //make arraylist out of ppl
         ArrayList<Person> list = new ArrayList<Person>(Arrays.asList(ppl));
      // sort the list
         Collections.sort(list);
         // return # two friends from first person in list 
         Person mostPopular = list.get(0);
         
         int result = mostPopular.twoFriendCount;
         if(result>0){result -= 1;}
         return result; 
      }
      
//      public static void main(String[] args){
//    	  FriendScore fs = new FriendScore();
//    	  String[] test1 = {"NYY", "YNY", "YYN"};
//    	  int result = fs.highestScore(test1);
//    	  System.out.println("Expected 2, got " +result);
//    	  System.out.println();
//    	  
//    	  String[] test2 = {"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};
//    	  result = fs.highestScore(test2);
//    	  System.out.println("Expected 4, got " +result);
//    	  System.out.println();
//      }
      
      
      public class Person implements Comparable<Person>{

    	int myId;
    	HashSet<Person> myFriends = new HashSet<Person>();
    	HashSet<Person> myTwoFriends = new HashSet<Person>();
    	int oneFriendCount;
    	int twoFriendCount; 
    	
    	public Person(int id){
    		myId = id;
    		oneFriendCount = 0; 
    		twoFriendCount = 0; 
    	}
    	
    	public void addFriend(Person f){
    		(this.myFriends).add(f); 
    	}
    	
    	public void addTwoFriends(){
    		for(Person f : this.myFriends){
    			this.myTwoFriends.add(f);
    			for(Person tf : f.myFriends){
    				this.myTwoFriends.add(tf);
    			}
    		}
    	}
    	
    	public void countFriends(){
    		int tmp = (this.myFriends).size();
    		this.oneFriendCount = tmp;
//    		System.out.println(tmp);
    	}
    	
    	public void countTwoFriends(){
    		this.twoFriendCount = (this.myTwoFriends).size();
    	}
    	
    	
		@Override
		public String toString(){
			return ("I have " + this.twoFriendCount + " two-friends.");
		}
		public int compareTo(Person arg0) {
			int f1 = this.twoFriendCount;
			int f2 = arg0.twoFriendCount;
			return -(f1 - f2);
		}
    	  
      }
   }