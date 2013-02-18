import java.io.File;


public class DirSearch {

	public File dirSearch(File root, String fileName){
		File[] files = root.listFiles();
		
		return root;
	}

	public static void main(String[] args){
		DirSearch search = new DirSearch();
		File f = search.dirSearch(new File("/Users"), "DirSearch.java"); //Mac
		//File f = search.dirSearch(new File("C:\\"), "DirSearch.java"); //Windows
		System.out.println(f.toString());
	}
}
