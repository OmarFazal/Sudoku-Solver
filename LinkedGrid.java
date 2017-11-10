package codes;

public class LinkedGrid {

	private static Node root;
	private int dimension = 9;

	public LinkedGrid() {
		Node temp = new Node(0); // First Node
		root = temp;
		Node Marker = root;
		for(int x = 0; x < dimension - 1; x++){ // First Row
		temp = new Node(0);
		Marker.setRight(temp);
		temp.setLeft(Marker);
		Marker = temp;
		}
		//First node in second row
		Marker = root;
		Node rowMarker = root;
		for(int y = 0; y < dimension - 1; y++){
		temp = new Node(0);
		temp.setUp(rowMarker);
		rowMarker.setDown(temp);
		rowMarker = temp;
		Marker = rowMarker;
		
		for(int x = 0; x < dimension - 1; x++){ // every row after first
			temp = new Node(0);
			Marker.setRight(temp);
			temp.setLeft(Marker);
			temp.setUp(temp.getLeft().getUp().getRight());
			temp.getLeft().getUp().getRight().setDown(temp);
			Marker = temp;
		}
	}
}
	
	
	public void display(){
		Node temp = root;
		Node rowMarker = root;
		
		for(int x = 0; x < dimension; x++){
			for(int y = 0; y < dimension; y++){
				System.out.printf("%3d", temp.getData());
				temp = temp.getRight();
			}
			System.out.println();
			temp = rowMarker.getDown();
			rowMarker = temp;
		}
		System.out.println();
}
}
