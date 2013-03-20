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
		if(line.substring(0, 3)=="#Q:"){ return false; }
		else { return true; } 
	}

	@Override
	public void newGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processYesNo(boolean yes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setView(AnimalGameViewer view) {
		myView = view;
	}

	@Override
	public void write(FileWriter writer) {
		// TODO this is the second thing to do 
		
		
	}
}
