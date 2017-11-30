package codes;

public class LinkedGrid {

	private static Node root;
	private int dimension = 9;

	public LinkedGrid() {
		Node temp = new Node(-1); // First Node
		root = temp;
		Node Marker = root;
		for (int x = 0; x < dimension - 1; x++) { // First Row
			temp = new Node(-1);
			Marker.setRight(temp);
			temp.setLeft(Marker);
			Marker = temp;
		}
		// First node in second row
		Marker = root;
		Node rowMarker = root;
		for (int y = 0; y < dimension - 1; y++) {
			temp = new Node(-1);
			temp.setUp(rowMarker);
			rowMarker.setDown(temp);
			rowMarker = temp;
			Marker = rowMarker;

			for (int x = 0; x < dimension - 1; x++) { // every row after first
				temp = new Node(-1);
				Marker.setRight(temp);
				temp.setLeft(Marker);
				temp.setUp(temp.getLeft().getUp().getRight());
				temp.getLeft().getUp().getRight().setDown(temp);
				Marker = temp;
			}
		}
	}

	public Node nodeAt(int x, int y) {
		Node n = root;
		for (int i = 0; i < x; i++)
			n = n.getRight();
		for (int i = 0; i < y; i++)
			n = n.getDown();
		return n;
	}
	

	public void setBoxIDnumb() {
//		Node temp = root;
//		Node rowMarker = root;
		int boxIDNum = 1;
		int x = 0;
		int y = 0;
		for (int i = 0; i < 3; i++) { // moves along the vertical, large boxes
			for (int z = 0; z < 3; z++) { // moves along the horizontal, large box

				for (int j = 0; j < 3; j++) { // sets the box ID number for a box
					for (int k = 0; k < 3; k++) {
						nodeAt(z * 3 + j, i * 3 + k).setBoxID(boxIDNum);

						// temp.setBoxID(boxIDNum);
						// temp = temp.getRight();

					}
					// temp = rowMarker.getDown();
					// rowMarker = temp;
					// System.out.println("test");
				}
				// if(x < 9){
				boxIDNum++;
				// x += 3;
				// temp = nodeAt(x, y);
				// rowMarker = temp;
				// }
			}
			//// if (y < 9) {
			// x = 0;
			// y += 3;
			// temp = nodeAt(x, y);
			// rowMarker = temp;
		}
	}
	// }

	public void displayBool(int i) {
		// Node temp = nodeAt(x, y);
		// for (int i = 0; i < 9; i++)
		Node n = root;
		Node rowMarker = root;
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				System.out.print(n.getPossibilities()[i] + " ");
				n = n.getRight();
			}
			System.out.println();
			n = rowMarker.getDown();
			rowMarker = n;
		}
	}

	public static Node getRoot() {
		return root;
	}

	public static void setRoot(Node root) {
		LinkedGrid.root = root;
	}

	public void display() {
		Node temp = root;
		Node rowMarker = root;

		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
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
