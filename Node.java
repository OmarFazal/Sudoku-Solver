package codes;

public class Node {
	private int data;
	private Node up;
	private Node down;
	private Node left;
	private Node right;
	private int boxID;
	private boolean[] possibilities = new boolean[10];
	Node(int data){
		this.data = data;
		for(int i = 0; i<10; i++){
			possibilities[i]=true;
		}
	}

	public int getBoxID() {
		return boxID;
	}

	public void setBoxID(int boxID) {
		this.boxID = boxID;
	}

	public boolean[] getPossibilities() {
		return possibilities;
	}

	public void setPossibilities(int x, boolean b) {
		this.possibilities[x] = b;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
}

