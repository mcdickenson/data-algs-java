public class DNAcgcount
{
    public double ratio(String dna)
    {
    	double cgCount = 0.0;
    	for (int i = 0; i < dna.length(); i++){
    	    char letter = dna.charAt(i);        
    	    if(letter == 'c' || letter == 'g'){
    	    	cgCount += 1.0;
    	    }
    	}
    	
    	double cgRatio = 0.0 ; 
    	if(dna.length()>0){ cgRatio = cgCount / dna.length(); }
    	return cgRatio; 
    }
 
}
