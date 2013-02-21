import java.util.*; 

public class TournamentRanker  {
      public String[] rankTeams(String[] names, String[] lostTo) {
          int size = names.length;   
          Player[] players = new Player[size]; 

    	  // set up array of players 
    	  for(int i=0; i<size; i++){
    		  Player player = new Player(names[i], lostTo[i]);
    		  players[i] = player;
    		  for(int j=0; j<size; j++){
    			  if(lostTo[j]==names[i]){ player.myWins += 1; }
    		  }
    	  }
    	  
    	  // indicate who each player lost to 
    	  for(int i=0; i<size; i++){
    		  Player p1 = players[i]; 
    		  for(int j=0; j<size; j++){
    			  Player p2 = players[j];
    			  if(p1.myLostString.equals(p2.myName)){ p1.myLostTo = p2; }
//    			  if(lostTo[j]==names[i]){ player.myLostTo = players[i]; }
    		  }
    	  }
    	  
    	  // sort 
    	  List<Player> pList = Arrays.asList(players);
   	   	  Collections.sort(pList); 
    	  
   	   	  String[] output = new String[size]; 
   	   	  for(int i=0; i<size; i++){
   	   		  output[i] = players[i].toString(); 
   	   	  }
   	   	  
    	  return output; 
      }
      
      
      public class Player implements Comparable<Player>{
    	  public String myName; 
    	  public int myWins;
    	  public String myLostString; 
    	  public Player myLostTo; 
    	  
    	  public Player(String name, String lostToName){
    		  myName = name;
    		  myWins = 0; 
    		  myLostString = lostToName; 
    	  }

		@Override
		public String toString(){
			return this.myName; 
		}
		
		public int compareTo(Player arg0) {
			int wins = this.myWins - arg0.myWins;
			if(wins != 0){ return -wins; }
			else{ return (this.myLostTo).compareTo(arg0.myLostTo); }
		}
   }
      
//   public static void main(String[] args){
//	   TournamentRanker t = new TournamentRanker(); 
//	   String[] names = {"RODDICK", "SCHUETTLER", "FERREIRA", "AGASSI"}; 
//	   String[] lostTo = {"SCHUETTLER", "AGASSI", "AGASSI", ""};
//	   String[] result = t.rankTeams(names, lostTo);
//	   for(String r: result){
//		   System.out.println(r); 
//	   }
//   }
}
