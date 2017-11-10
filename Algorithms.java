package codes;

public class Algorithms {

	private static boolean[] possibilities = new boolean[9];
	
	public static void display(){
		for(int i = 0; i < 9; i++)
		System.out.println(possibilities[i]);
	}
	
	public void rowSolver(){
		
	}
	
	
	
	
	
	
	public static void main(String[] args){
		LinkedGrid ll = new LinkedGrid();
		ll.display();
		display();
	}
}
