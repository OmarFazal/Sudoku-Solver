package codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadSave {

	public static int[][] board = new int[9][9];
	
	public static void loadFromText() throws FileNotFoundException {
		Node root = null;
		root = LinkedGrid.getRoot();
		Node temp = root;
		Node rowMarker = root;
		String res = "H:\\Omar Fazal\\Sudoku Solver\\src\\codes\\Test_Sudoku.txt";
		File file = new File(res);
		int data;
		Scanner input = new Scanner(file);
		int counter = 0;
		while(input.hasNext()) {
			data = input.nextInt();
			counter++;
			temp.setData(data);
			temp = temp.getRight();
			if(counter % 9 == 0){
				temp = rowMarker.getDown();
				rowMarker = temp;
			}
		}
	}
}