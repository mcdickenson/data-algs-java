/*
 * This class encapsulates N words/strings so that the
 * group of N words can be treated as a key in a map or an
 * element in a set, or an item to be searched for in an array.
 * <P>
 * @author Matt Dickenson
 */

public class WordNgram implements Comparable<WordNgram>{
    
    private String[] myWords;
    
    /*
     * Store the n words that begin at index start of array list as
     * the N words of this N-gram.
     * @param list contains at least n words beginning at index start
     * @start is the first of the N words to be stored in this N-gram
     * @n is the number of words to be stored (the n in this N-gram)
     */
    public WordNgram(String[] list, int start, int n) {
        myWords = new String[n];
        System.arraycopy(list, start, myWords, 0, n);
    }
    
    /**
     * Return value that meets criteria of compareTo conventions.
     * @param wg is the WordNgram to which this is compared
     * @return appropriate value less than zero, zero, or greater than zero
     */
    public int compareTo(WordNgram wg) {
        int size = this.myWords.length;
        for(int i=0; i<size; i++){
        	String thisWord = this.myWords[i];
        	String thatWord = wg.myWords[i];
        	int compare = thisWord.compareTo(thatWord);
        	if(compare!=0){return compare;}
        }
        return 0;
    }
    
    /**
     * Return true if this N-gram is the same as the parameter: all words the same.
     * @param o is the WordNgram to which this one is compared
     * @return true if o is equal to this N-gram
     */
    public boolean equals(Object o){
        WordNgram wg = (WordNgram) o;
        int compare = this.compareTo(wg);
        if(compare != 0){return false;}
        return true;
    }
    
    /**
     * Returns a good value for this N-gram to be used in hashing.
     * @return value constructed from all N words in this N-gram
     */
    public int hashCode(){
    	String cat = "";
        for(String w : this.myWords){
        	cat = cat + w;
        }
    	
        return cat.hashCode();
    }
    
    /**
     * Returns this size of the array myWords 
     */
    public int numWords(){
    	return this.myWords.length;
    }
    
    /**
     * Gets the last string in myWords array
     * @return value is used to build the output string in WordMarkovModel
     */
    public String getLast(){
    	return this.myWords[this.myWords.length-1];
    }
    
}
