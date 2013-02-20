import java.lang.Math; 

public class Tourney {
      public String winner(String[] bracket, String results) {
           // fill in code here
    	  
    	  int numGames = results.length(); 
    	  int numTeams = bracket.length; 
    	  if(numTeams==1){ return bracket[0]; }
    	  String[] nextRound = new String[numTeams/2]; 
    	  String victor =""; 
    	  String result; 
    	  for(int i=0; i<numTeams; i+=2){
    		  String team1 = bracket[i];
//    		  System.out.println(team1);
    		  String team2 = bracket[i+1];
//    		  System.out.println(team2);
    		  if(team1.equals("bye")){ victor = team2; }
    		  else if(team2.equals("bye")){ victor = team1; }
    		  else{
    			  result = results.substring(0,1); 
    			  results = results.substring(1);
    			  if(result.equals("L")){ victor = team2; }
    			  else if(result.equals("H")){ victor = team1; }
    		  }
    		  nextRound[i/2] = victor; 
//    		  System.out.println("winner: " + victor); 
//    		  System.out.println("results: " + results );
    	  }
//    	  System.out.println("next round:");
//    	  for(String team : nextRound){
////    		  System.out.println(team);
//    	  }
    	  return winner(nextRound, results); 
      }
      
//      public static void main(String[] args){
//    	  Tourney t = new Tourney(); 
//    	  String[] bracket = {"A","B","C","bye","D","E","F","bye"}; 
//    	  String results = "LHHLH"; 
//    	  String victor = t.winner(bracket, results);
//    	  System.out.println(victor); 
//      }
}