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
    
	@Override
	public void addNewKnowledge(String question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewQuestion(String noResponse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialize(Scanner s) {
		// recursively read in the game tree
		// tree written with pre-order traversal with interior nodes marked by "#Q:"
		myRoot = readHelper(s); 
		
		myView.setEnabled(true);
		
		newGame();
	}
	
	private AnimalNode readHelper(Scanner s){
		String line = s.nextLine();
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
		if(yes){ node = myCurrent.getYes(); }
		else{ node = myCurrent.getNo();	}
		
		if(node==null && yes){
			myView.showDialog("I won!");
		}
		else if(node==null && !yes){
			myView.showDialog("You won!"); // this is temporary
		}
		else{
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
