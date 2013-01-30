import java.util.*; 

public class MedalTable{
   public String[] generate(String[] results) {

	   HashMap<String, Country> table = new HashMap<String, Country>();
	   
	   for(String result : results){
		   String[] countries = result.split(" ");
		   
		   //make sure countries are in table
		   for(String cname : countries){
			   if(table.containsKey(cname)){;}
			   else{
				   Country c = new Country(cname, 0,0,0);
				   table.put(cname, c);
			   }
		   }
		   
		   // increment medal counts
		   (table.get(countries[0])).myGold += 1;
		   (table.get(countries[1])).mySilver += 1;
		   (table.get(countries[2])).myBronze += 1; 
	   }
	   
	   // convert hashmap to list for sorting
	   List<Country> list = new ArrayList<Country>(table.values());
	   Collections.sort(list); 
	   
	   //return array of Strings 
	   String[] output = new String[list.size()];
       
       for(int i=0; i<list.size(); i++){
       	output[i] = (list.get(i)).toString();
       }
       
       return output; 
   }
   
   public class Country implements Comparable<Country>{
	   String myName;
	   int myGold;
	   int mySilver;
	   int myBronze;
	   
	   public Country(String n, int g, int s, int b){
		   myName = n;
		   myGold = g;
		   mySilver = s;
		   myBronze = b;
	   }
	   
   
		@Override
		public String toString()
		{
			return myName + " " + myGold + " " + mySilver + " " + myBronze;
		}
		
		public int compareTo(Country arg0) {
			int gold = this.myGold - arg0.myGold; 
			if(gold==0){
				int silver = this.mySilver - arg0.mySilver;
				if(silver==0){
					int bronze = this.myBronze - arg0.myBronze;
					if(bronze==0){
						return (this.myName).compareTo(arg0.myName); 
					}
					else{return -bronze;}
				}
				else{
					return -silver; 
				}
			}
			else{
				return -gold; 
			}
		}
	}
   
 }