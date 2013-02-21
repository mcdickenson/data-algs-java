public class Tourney {
      public String winner(String[] bracket, String results) {
    	  int numTeams = bracket.length; 
    	  if(numTeams==1){ return bracket[0]; }
    	  String[] nextRound = new String[numTeams/2]; 
    	  String victor =""; 
    	  String result; 
    	  for(int i=0; i<numTeams; i+=2){
    		  String team1 = bracket[i];
    		  String team2 = bracket[i+1];
    		  if(team1.equals("bye")){ victor = team2; }
    		  else if(team2.equals("bye")){ victor = team1; }
    		  else{
    			  result = results.substring(0,1); 
    			  results = results.substring(1);
    			  if(result.equals("L")){ victor = team2; }
    			  else if(result.equals("H")){ victor = team1; }
    		  }
    		  nextRound[i/2] = victor; 
    	  }
    	  return winner(nextRound, results); 
      }
}