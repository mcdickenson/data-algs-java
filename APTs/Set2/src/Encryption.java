import java.util.*;


  public class Encryption {
       public String encrypt(String message){
           // you write code here
    	   String alphabet = "abcdefghijklmnopqrstuvwxyz";
    	   HashMap lettersCoded = new HashMap(); 
    	   int size = 0; 
    	   for(int i=0; i<message.length(); i++){
    		   char letter = message.charAt(i);
    		   if (!lettersCoded.containsKey(letter)){
    			   lettersCoded.put(letter, alphabet.charAt(size) ); 
    			   size += 1;
    		   }
    	   }
    	   char[] array = new char[message.length()]; 
    	   for(int j=0; j<message.length(); j++){
    		   array[j] =  (Character) lettersCoded.get(message.charAt(j)); 
    	   }
    	   String output = new String(array); 
    	   return output; 
       }
       
//       public static void main(String[] args){
//    	   Encryption en = new Encryption(); 
//    	   String message1 = "hello";
//    	   String test1 = en.encrypt(message1);
//    	   System.out.println(test1); 
//    	   
//    	   String message2 = "abcd";
//    	   String test2 = en.encrypt(message2);
//    	   System.out.println(test2); 
//    	   
//    	   System.out.println(en.encrypt("topcoder"));
//       }
   }