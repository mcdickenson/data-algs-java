
public class LinkStrand implements IDnaStrand{
	
	private Node myFirst, myLast; // first and last nodes of list
	private long mySize;
	private StringBuilder myInfo;
    private int myAppends;
	
    /**
     * Create a strand representing an empty DNA strand, length of zero.
     */
    public LinkStrand() {
    	// Syntactic trick: calls the other constructor (the one that
    	// takes a String) with an empty String.
    	this("");
    }
    
	/**
     * Create a strand representing s. No error checking is done to 
     * see if s represents valid genomic/DNA data.
     * @param s is the source of cgat data for this strand
     */
    public LinkStrand(String s) {
        myFirst = new Node(s);
        myLast = myFirst;
        mySize = s.length(); 
    }
	
	@Override
	/**
     * Cut this strand at every occurrence of enzyme, essentially replacing
     * every occurrence of enzyme with splicee.
     * @param enzyme is the pattern/strand searched for and replaced
     * @param splicee is the pattern/strand replacing each occurrence of enzyme
     * @return the new strand leaving the original strand unchanged.
     */
	public IDnaStrand cutAndSplice(String enzyme, String splicee) {
		// allowed to assume only one node, though can be huge:
		if (myFirst.next != null){
	        throw new RuntimeException("link strand has more than one node"); 
	    }
		
      int pos = 0;
      int start = 0;
      String search = this.toString();
      boolean first = true;
      LinkStrand ret = null;
      
      /*
       * The next line is very syntax-dense. .indexOf looks for the 
       * first index at which enzyme occurs, starting at pos. Saying 
       * pos = ... assigns the result of that operation to the pos
       * variable; the value of pos is then compared against zero.
       * 
       * .indexOf returns -1 if enzyme can't be found. Therefore, this
       * line is:
       * 
       * "While I can find enzyme, assign the location where it occurs
       * to pos, and then execute the body of the loop."
       */
      while ((pos = search.indexOf(enzyme, pos)) >= 0) {
          if (first){
              ret = new LinkStrand(search.substring(start, pos));
              first = false;
          }
          else {
               ret.append(search.substring(start, pos));
               
          }
          start = pos + enzyme.length();
          ret.append(splicee);
          pos++;
      }

      if (start < search.length()) {
      	// NOTE: This is an important special case! If the enzyme
      	// is never found, return an empty String.
      	if (ret == null){
      		ret = new LinkStrand("");
      	}
      	else {
      		ret.append(search.substring(start));
      	}
      }
      return ret;
	}

	@Override
	public long size() {
		return mySize;
	}
	
	@Override
	public String toString(){
		myInfo = new StringBuilder(); 
		Node n = myFirst; 
		myInfo.append(n.info);
		while(n.next != null){
			n = n.next;
			myInfo.append(n.info);
		}
		String output = myInfo.toString(); 
		return output; 
	}

	@Override
	// @param source is the source of this enzyme
	public void initializeFrom(String source) {
		myFirst = new Node(source);
		myLast = myFirst;
        mySize = source.length(); 
	}

	@Override
	/**
     * Return some string identifying this class.
     * @return a string representing this strand and its characteristics
     */
	public String strandInfo() {
        return this.getClass().getName();
    }

	@Override
	/**
     * Appends the parameter to this strand changing this strand to represent
     * the addition of new characters/base-pairs, e.g., changing this strand's
     * size.
     * <P>
     * If possible implementations should take advantage of optimizations
     * possible if the parameter is of the same type as the strand to which data
     * is appended.
     * 
     * @param dna is the strand being appended
     * @return this strand after the data has been added
     */
	public IDnaStrand append(IDnaStrand dna) {
		if (dna instanceof LinkStrand) {
            myLast.next = ((LinkStrand) dna).myFirst;
            myLast = ((LinkStrand) dna).myLast; 
            mySize += dna.size(); 
            myAppends++;
            return this;
        } else {
            return append(dna.toString());
        }
	}

	@Override
	/**
     * Similar to append with an <code>IDnaStrand</code> parameter in
     * functionality, but fewer optimizations are possible. Typically this
     * method will be called by the  <code>append</code> method with an IDNAStrand
     * parameter if the
     * <code>IDnaStrand</code> passed to that other append method isn't the same class as the strand
     * being appended to.
     * 
     * @param dna is the string appended to this strand
     * @return this strand after the data has been added
     */
	public IDnaStrand append(String dna) {
		Node n = new Node(dna);
		myLast.next = n;
		myLast = n; 
		mySize += dna.length(); 
		myAppends++; 
		return this;
	}

	@Override
	/**
     * Returns an IDnaStrand that is the reverse of this strand,
     * e.g., for "CGAT" returns "TAGC"
     * @return reverse strand
     */
	public IDnaStrand reverse() {
		LinkStrand copy = this; 
		StringBuilder rev = new StringBuilder();
		rev.append(myFirst.info);
		rev.reverse();
		LinkStrand ls = new LinkStrand(rev.toString());
		copy.myFirst = copy.myFirst.next; 
		
		while(ls.size() < mySize){
			Node tmp = copy.myFirst;
			copy.myFirst = copy.myFirst.next; 
			tmp.next = null; 
			rev = new StringBuilder();
			rev.append(tmp.info);
			rev.reverse();
			ls.append(rev.toString()); 
		}
		
		return ls;
	}

	@Override
	/**
     * Returns a string that can be printed
     * to reveal information about what this
     * object has encountered as it is manipulated
     * by append and cutAndSplice.
     * @return
     */
	public String getStats() {
		return String.format("# append calls = %d",myAppends);
	}

	// use Node class for list
	public class Node{
		String info;
		Node next;
		Node(String s){
			info = s;
			next = null;
		}
	}
}
