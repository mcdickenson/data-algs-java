public class AccessLevel{

	public static void main(String[] args){
		AccessLevel al = new AccessLevel();

		int[] test1 = {0,1,2,3,4,5};
		String result1 = al.canAccess(test1, 2);

		System.out.println(result1);
	}

	public String canAccess(int[] rights, int minPermission){
		StringBuilder permissions = new StringBuilder();

		for(int right : rights){
			if(right < minPermission){
				permissions.append("D");
			} else {
				permissions.append("A");
			}
		}

		String output = permissions.toString();
		return output; 
	}
}