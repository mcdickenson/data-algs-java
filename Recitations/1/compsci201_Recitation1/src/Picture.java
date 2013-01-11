public class Picture {
	public static void main(String[] args) {
		Picture p = new Picture();
		p.draw();
	}

	//TODO: Improve this method through using loops
	private void draw() {	
		int i = 1;
		int j = 1;
		while(i <= 10){
			while(j<i){
				System.out.print("*");
				j++;
			}
			System.out.println("*");
			i++;
			j=1;
		}
	}
}
