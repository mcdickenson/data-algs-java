/*
It should be noted that this is neither a complete java file nor all the solution to all of the questions for this recitation. It is the code for the problems that are for getting you used to Tries, but not the code that is a direct part of the Boggle assignment.

Additionally several of the questions from the recitation were non-coding questions. Those are not included in this file.

*/

 private Node copyTrie(Node root){

    if (root == null) return null;

    Node copy = new Node(root.info.charAt(0),null);
    copy.isWord = root.isWord;
    copy.info = root.info;

    // now copy children of root and then set all
    // the copied children's parents pointers to 'copy'

    for(Character c : root.children.keySet()){
      Node child = root.children.get(c);
      Node childCopy = copyTrie(child);

      childCopy.parent = copy;
      copy.children.put(c, childCopy);
    }


    return copy;
  }

  private int wordCount(Node root){

    if (root == null) return 0;

    int result = 0;
    if(root.isWord)
      result++;


    for(Character c : root.children.keySet()){
      result += wordCount(root.children.get(c));
    }

    return result;

  }
