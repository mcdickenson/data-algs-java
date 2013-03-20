/**
 * @author Owen Astrachan
 * @date March 15, 2010
 */
public class GameMain {
    public static void main(String[] args){
	    AnimalGameViewer view = 
	    		new AnimalGameViewer("Twenty Questions");
	    IAnimalModel gm = new AnimalGameModel();
	    view.setModel(gm);
    }
}
