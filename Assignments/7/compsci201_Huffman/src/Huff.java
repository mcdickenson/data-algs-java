
/**
 * Main/launch program for Huff assignment. A better
 * comment than this is warranted.
 * @author Matthew Dickenson
 *
 */
public class Huff {

    public static void main(String[] args){
        HuffViewer sv = new HuffViewer("Duke Compsci Huffing");
        IHuffProcessor proc = new SimpleHuffProcessor();
        sv.setModel(proc);    
    }
}
