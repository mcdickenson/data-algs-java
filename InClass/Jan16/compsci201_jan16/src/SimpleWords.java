import java.io.*;
import java.util.*;

public class SimpleWords {

    public void countWordsLoop(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner sc = new Scanner(f);
        ArrayList<String> list = new ArrayList<String>();
        while (sc.hasNext()) {
            list.add(sc.next());
        }
        HashSet<String> set = new HashSet<String>(list);
        System.out.printf("total number of words = %d\n", list.size());
        System.out.printf("unique # words = %d\n", set.size());

    }

    public void countWords(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner sc = new Scanner(f);
        String wholeThing = sc.useDelimiter("\\Z").next();
        String[] words = wholeThing.split("\\s+");
        HashSet<String> set = new HashSet<String>(Arrays.asList(words));
        System.out.printf("total number of words = %d\n", words.length);
        System.out.printf("unique # words = %d\n", set.size());
    }

    public static void main(String[] args) throws FileNotFoundException {
        SimpleWords sw = new SimpleWords();
        
        System.out.println("****ArrayList****");
        double start = System.currentTimeMillis();
        sw.countWordsLoop("lowerwords.txt");
        double end = System.currentTimeMillis();
        System.out.printf("total time = %f\n", (end - start) / 1000);

    	System.out.println("****Array****");
        start = System.currentTimeMillis();
        sw.countWords("lowerwords.txt");
        end = System.currentTimeMillis();
        System.out.printf("total time = %f\n", (end - start) / 1000);
    }
}