package codes;

import java.io.FileNotFoundException;

public class Algorithms {

	// public static void startSudoku() {
	// Node temp = LinkedGrid.getRoot();
	// Node rowMarker = temp;
	// for (int x = 0; x < 9; x++) {
	// for (int y = 0; y < 9; y++) {
	// if (temp.getData() != 0)
	// temp.setPossibilities(temp.getData(), false);
	// temp = temp.getRight();
	// }
	//
	// temp = rowMarker.getDown();
	// rowMarker = temp;
	// }
	// }
	public static void rowSolve() {
		Node temp = LinkedGrid.getRoot();
		Node rowMarker = temp;
		Node marker = temp;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				while (marker.getRight() != null && temp.getData() != 0) {
					marker = marker.getRight();
					marker.setPossibilities(temp.getData(), false);
				}
				while (marker.getLeft() != null && temp.getData() != 0) {
					marker = marker.getLeft();
					marker.setPossibilities(temp.getData(), false);
				}
				temp.setPossibilities(temp.getData(), true);
				temp = temp.getRight();
				marker = temp;
			}
			temp = rowMarker.getDown();
			rowMarker = temp;
			marker = temp;
		}
	}

	public static void columnSolve() {
		Node temp = LinkedGrid.getRoot();
		Node rowMarker = temp;
		Node marker = temp;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				while (marker.getUp() != null && temp.getData() != 0) {
					marker = marker.getUp();
					marker.setPossibilities(temp.getData(), false);
				}
				while (marker.getDown() != null && temp.getData() != 0) {
					marker = marker.getDown();
					marker.setPossibilities(temp.getData(), false);
				}
				temp.setPossibilities(temp.getData(), true);
				temp = temp.getRight();
				marker = temp;
			}
			temp = rowMarker.getDown();
			rowMarker = temp;
			marker = temp;
		}
	}

	public static Node nodeAt(int x, int y) {
		Node n = LinkedGrid.getRoot();
		for (int i = 0; i < x; i++)
			n = n.getRight();
		for (int i = 0; i < y; i++)
			n = n.getDown();
		return n;
	}

	public static void sectionSolve() {
		Node temp = LinkedGrid.getRoot();
		LinkedGrid lg = new LinkedGrid();
		Node marker = temp;
		Node rowMarker = temp;
		int sec = 0;
		while (temp.getRight() != null && temp.getDown() != null) {
			int count = 0;
			sec = temp.getBoxID();
			marker = nodeAt((sec / 3) * 3, (sec / 3) * 3);
			for (int x = 0; x < 3; x++) { // makes the box false for that number
				for (int y = 0; y < 3; y++) {
					if(count >= 1)
					marker.setPossibilities(temp.getData(), false);
					if(marker.getRight() != null)
					marker = marker.getRight();
					count++;
				}
				marker = rowMarker.getDown();
				rowMarker = marker;
			}
//				temp = rowMarker.getDown();
//				rowMarker = temp;
				temp = temp.getRight();
				marker = temp;

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		LinkedGrid lg = new LinkedGrid();
		Node temp = lg.getRoot();
		Node rowmarker = temp;
		LoadSave.loadFromText();
		lg.display();
		// rowSolve();
		// columnSolve();
		lg.setBoxIDnumb();
		System.out.println();
		sectionSolve();
		lg.displayBool(2);
		System.out.println();
		lg.displayBool(3);
		System.out.println();
		lg.displayBool(4);
	}
}
// for (int i = 0; i < 9; i++) { // shows the boxID numbers
// for (int j = 0; j < 9; j++) {
// System.out.print(temp.getBoxID());
// temp = temp.getRight();
// }
// temp = rowmarker.getDown();
// rowmarker = temp;
// System.out.println();
// }