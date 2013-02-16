/**
 * Main for Markov Text Generation Program
 * @author ola
 * @date Jan 12, 2008
 *
 */
public class MarkovMain {
    public static void main(String[] args){
        IModel model = new MapMarkovModel();
        SimpleViewer view = new SimpleViewer("Compsci 100 Markov Generation", "k count>");
        view.setModel(model);
    }
}
