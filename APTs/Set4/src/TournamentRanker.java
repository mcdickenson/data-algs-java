import java.util.*; 

public class TournamentRanker  {
      public String[] rankTeams(String[] names, String[] lostTo) {
          int size = names.length; 
          
//          HashSet<String> namesToRank = new HashSet<String>(); 
          List<String> namesToRank = new ArrayList<String>(); 
          HashMap<String, String> namesLostTo = new HashMap<String, String>();
          HashMap<String, Integer> namesWins = new HashMap<String, Integer>(); 
//          HashMap<String, Integer> namesIndices = new HashMap<String, Integer>(); 
          
          for(int i=0; i<size; i++){
        	  namesLostTo.put(names[i], lostTo[i]);
        	  namesWins.put(names[i], 0);
//        	  namesIndices.put()
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
    	  
          // while namesToRank is non-empty
          // find who has max wins
          // see whether someone else has equal wins
          //   if they do, recurse 
          //   if they don't, personWithMaxWins gets added to output
          List<String> list = new ArrayList<String>();
          
//          while(!(namesToRank.isEmpty())){
////        	  String personWithMax = getWinner(namesToRank, namesLostTo, namesWins);
//        	  namesToRank.remove(personWithMax); 
//        	  list.add(personWithMax); 
//          }
          
//          for(int i=0; i<size; i++){
          while(!(namesToRank.isEmpty())){
//        	  String rowPlayer = names[i]; 
        	  String rowPlayer = namesToRank.get(0);
        	  String playerWithMax = rowPlayer; 
        	  for(String columnPlayer:namesToRank){
        		  if(columnPlayer.equals(rowPlayer)){continue;}
        		  playerWithMax = hasMost(playerWithMax, columnPlayer, namesLostTo, namesWins);
        	  }
        	  namesToRank.remove(playerWithMax);
//        	  for(int j=0; j<size; j++){
//        		  String columnPlayer = names[j];
//        		  if(j==i){ continue; }
//        		  if(!(list.contains(columnPlayer))){
//        			  playerWithMax = hasMost(playerWithMax, columnPlayer, namesLostTo, namesWins);
//        		  }	  
//        	  }
        	  list.add(playerWithMax);
        	  System.out.println(playerWithMax); 
//        	  names
          }
          
          String[] output = list.toArray(new String[list.size()]);
          return output; 
      }
      
//      public String getWinner(HashSet<String> namesToRank,
//    		  HashMap<String, String> namesLostTo, HashMap<String, Integer> namesWins){
//    	  
//    	  // get max number of wins
//    	  int maxWins = 0; 
//    	  for(String name: namesWins.keySet()){
//    		  int wins = namesWins.get(name);
//    		  if(wins > maxWins){ maxWins = wins; }
//          }
//    	  
//    	  List<String> hasMax = new ArrayList<String>();
//    	  for(String name: namesWins.keySet()){
//    		  int wins = namesWins.get(name);
//    		  if(wins == maxWins){ hasMax.add(name); }
//          }
//    	  
//    	  if(hasMax.size()==1){return hasMax.get(0); }
//    	  else{ return hasMost(hasMax.get(0), hasMax.get(1), namesLostTo, namesWins); }
//
//      }
      
      public String hasMost(String name1, String name2,
    		  HashMap<String, String> namesLostTo, HashMap<String, Integer> namesWins){
    	  int wins1 = namesWins.get(name1);
    	  int wins2 = namesWins.get(name2);
    	  if(wins1 > wins2){ return name1; }
    	  else if(wins2 > wins1){ return name2; }
    	  else{ 
    		  String whoBeat1 = namesLostTo.get(name1);
    		  String whoBeat2 = namesLostTo.get(name2);
    		  return hasMost(whoBeat1, whoBeat2, namesLostTo, namesWins); 
    	  }
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
