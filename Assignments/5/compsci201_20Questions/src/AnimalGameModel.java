/*
 * AnimalGameModel.java
 * Matt Dickenson
 * 
 * Implementation of IAnimalGameModel.
 */
import java.io.*;
import java.util.*;

public class AnimalGameModel implements IAnimalModel {
	
	// In Model-View systems, the Model & View must be able to communicate;
	// this pointer to the view lets you tell the view to do things (show messages,
	// for example).
	private AnimalGameViewer myView;
	private AnimalNode myRoot;
	private AnimalNode myCurrent; 
	private AnimalNode myPrevious;
	private AnimalNode myNewLeaf;
	private StringBuilder myPath; 
	private int mySize;
    
	@Override
	public void addNewKnowledge(String knowledge) {
		knowledge = knowledge.replace("?", "");
		AnimalNode newNo= new AnimalNode(knowledge, myCurrent, myNewLeaf);
		myPrevious.setNo(newNo);
		newGame();
	}

	@Override
	public void addNewQuestion(String question) {
		question = question.replace("?", "");
		AnimalNode newLeaf = new AnimalNode(question, null, null);
		myNewLeaf = newLeaf;
		myView.getDifferentiator();
	}

	@Override
	public void initialize(Scanner s) {
		myRoot = readHelper(s); 
		String nodesRead = "# nodes in tree read: " + Integer.toString(mySize); 
		myView.showMessage(nodesRead);
		myView.setEnabled(true);
		newGame();
	}
	
	private AnimalNode readHelper(Scanner s){
		String line = s.nextLine();
		mySize += 1;
		if( isLeaf(line) ){
			AnimalNode leafNode = new AnimalNode(line, null, null);
			
			return leafNode; 
		}
		line = line.substring(3);
				
		// Make a recursive call to read left subtree
		AnimalNode leftNode = readHelper(s); 
		// Make a recursive call to read right subtree
		AnimalNode rightNode = readHelper(s); 
		// Construct resulting AnimalNode and return it 
		AnimalNode newNode = new AnimalNode(line, leftNode, rightNode);
		return newNode; 
	}
	
	private boolean isLeaf(String line){
		if( line.startsWith("#Q:")){ return false; }
		else { return true; } 
	}

	@Override
	public void newGame() {
		myPath = new StringBuilder(); 
		myPath.append("First, enter the word you were thinking of\n");
		myPath.append("in the form of a question, e.g.,\n");
		myPath.append("Are you a rhinoceros?\n");
		myPath.append("Are you 'The Grapes of Wrath'?\n");
		myPath.append("\n");
		myPath.append("Then enter a question for which the\n");
		myPath.append("Your path below is a reminder.\n");
		myPath.append("answer is YES for what I said and NO for\n");
		myPath.append("the word you were thinking of.\n");
		myPath.append("Be careful not to contradict earlier\n");
		myPath.append("questions. Your path below is a reminder.\n");
		myPath.append("\n");
		myPath.append("\nYour path so far:\n");
		
		myCurrent = myRoot; 
		askQuestion(myCurrent);	
	}
	
	private void askQuestion(AnimalNode node){
		String data = node.toString(); 
		if(data.startsWith("#Q:")){
			data = data.substring(0, 3);
		}
		data = data + "?\n";
		StringBuilder sb = new StringBuilder();
		sb.append(data);
		myView.update(sb.toString());
	}

	@Override
	public void processYesNo(boolean yes) {
		AnimalNode node;
		String youSaid; 
		String question = myCurrent.toString();
		
		if(yes){ 
			node = myCurrent.getYes(); 
			youSaid = "You answered YES to ";
		}
		else{ 
			node = myCurrent.getNo();	
			youSaid = "You answered NO to ";
		}
		
		youSaid = youSaid + question + "\n"; 
		myPath.append(youSaid);
		
		// handle next question or end of game
		if(node==null && yes){ 
			myView.showDialog("I won!"); 
			newGame();
		}
		else if(node==null && !yes){ 
			myView.update(myPath.toString());
			myView.getNewInfoLeaf();
		}
		else{
			myPrevious = myCurrent;
			myCurrent = node;
			askQuestion(myCurrent);
		}	
	}

	@Override
	public void setView(AnimalGameViewer view) {
		myView = view;
	}

	@Override
	public void write(FileWriter writer) {
		writeHelper(myRoot, writer);
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeHelper(AnimalNode n, FileWriter w){
		String text; 
		
		// check whether node is a leaf
		if((n.getYes() == null) && (n.getNo() == null)){
			text = n.toString() + "\n"; 
			try {
				w.write(text);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			text = "#Q:" + n.toString() + "\n"; 
			try {
				w.write(text);
			} catch (IOException e) {
				e.printStackTrace();
			} 

			if(n.getYes() != null){
				writeHelper(n.getYes(), w); 
			}
			if(n.getNo() != null){
				writeHelper(n.getNo(), w); 
			}
		}
	}
	
}
