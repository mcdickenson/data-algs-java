//Each match ends in one of three possible results: 
//a home team victory, a draw, or an away team victory. 
//Each time a team wins, it is awarded 3 points. 
//When there's a draw, both teams are awarded 1 point. 
//No points are awarded for a loss. 
//The overall ranking of the teams is based on the total number of points received by each team.

//You are given a String[] matches. 
//The j-th character of the i-th element of matches denotes the result of 
//the match between team i and team j at team i's stadium. 
//'W' represents a home team victory, 
//'D' represents a draw, and 
//'L' represents an away team victory. 
//All characters on the main diagonal of matches will be '-' 
//because a team never plays against itself. 
//Return a int[] where the i-th element is the total number of points 
//received by the i-th team.


public class SoccerLeagues {
     public int[] points(String[] matches) {
    	int[] result = new int[matches.length];
        for(int i=0; i < matches.length; i++){
        	String match = matches[i];
        	for(int j=0; j<match.length(); j++){
        		 char gameOutcome = match.charAt(j);
        		 if(gameOutcome=='W'){result[i] += 3;}
        		 else if(gameOutcome=='D'){
        			 result[i] += 1;
        			 result[j] += 1;}
        		 else if(gameOutcome=='L'){result[j] += 3;}
        		 else{}
        	 }
        }
        
        return result; 
     }
 }
