import java.util.*; 

public class TournamentRanker  {
      public String[] rankTeams(String[] names, String[] lostTo) {
          int size = names.length; 

          List<String> namesToRank = new ArrayList<String>(); 
          HashMap<String, String> namesLostTo = new HashMap<String, String>();
          HashMap<String, Integer> namesWins = new HashMap<String, Integer>(); 
          
          for(int i=0; i<size; i++){
        	  namesLostTo.put(names[i], lostTo[i]);
        	  namesWins.put(names[i], 0);
        	  namesToRank.add(names[i]);
          }
         
          for(String name: namesWins.keySet()){
        	  for(String winner: lostTo){
        		  if(name.equals(winner)){
        			  int count = namesWins.get(name);
        			  count++;
        			  namesWins.put(name, count); 
        		  }
        	  }
          }

          List<String> list = new ArrayList<String>();
          
          // until all players have been ranked
         int numNames = namesToRank.size();
         while(numNames>0){
        	  // get a player who has not been ranked
        	  String rowPlayer = namesToRank.get(0);
        	  
        	  // temp assume this player has most
        	  String playerWithMax = rowPlayer; 
        	  
        	  // compare to all other unranked players
        	  if(namesToRank.size()>1){
	        	  for(String columnPlayer:namesToRank){
	        		  if(columnPlayer.equals(playerWithMax)){continue;}
	        		  playerWithMax = hasMost(playerWithMax, columnPlayer, namesLostTo, namesWins);
	        	  }
        	  }
        	  
        	  list.add(playerWithMax); // add playerWithMost to list of rankings
        	  namesToRank.remove(playerWithMax); // remove from list of unranked players
        	  numNames = namesToRank.size();
          }
          
          String[] output = list.toArray(new String[list.size()]);
          return output; 
      }
      
      
      public String hasMost(String name1, String name2,
    		  HashMap<String, String> namesLostTo, HashMap<String, Integer> namesWins){
    	  int wins1 = namesWins.get(name1);
    	  int wins2 = namesWins.get(name2);
    	  if(wins1 > wins2){ return name1; }
    	  else if(wins2 > wins1){ return name2; }
    	  else{ 
    		  String whoBeat1 = namesLostTo.get(name1);
    		  String whoBeat2 = namesLostTo.get(name2);
    		  String nextLevel = hasMost(whoBeat1, whoBeat2, namesLostTo, namesWins); 
    		  if((namesLostTo.get(name1)).equals(nextLevel)){ return name1; }
    		  else if((namesLostTo.get(name2)).equals(nextLevel)){ return name2; }
    	  }
    	  return ""; 
      }
      
   public static void main(String[] args){
	   TournamentRanker t = new TournamentRanker(); 
	   String[] names = {"RODDICK", "SCHUETTLER", "FERREIRA", "AGASSI"}; 
	   String[] lostTo = {"SCHUETTLER", "AGASSI", "AGASSI", ""};
	   String[] result = t.rankTeams(names, lostTo);
	   for(String r: result){
		   System.out.println(r); 
	   }
   }
}
