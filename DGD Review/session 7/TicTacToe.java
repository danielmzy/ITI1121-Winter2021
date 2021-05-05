import java.lang.Math;

public class TicTacToe {

	public static int row = 3;
	public static int col = 3;

	private int[][] matrix = new int[row][col];
	private int size = 0;

	public TicTacToe() {}

	public TicTacToe(TicTacToe t) {
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				this.matrix[i][j] = t.matrix[i][j];
			}
		}
		this.size = t.size;
	}

	public void print() {
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}	
	}

	public void add(int n) {
		matrix[size/row][size%col] = n;
		size++;
	}

	public boolean isFull() {
		return size == row*col;
	}

	public boolean isValid() {
		return occurence(matrix, 1) <= Math.ceil((row*col)/2) && occurence(matrix, 2) <= Math.ceil((row*col)/2);
	}

	private static int occurence(int[][] matrix, int elem) {
		int counter = 0;
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(matrix[i][j] == elem) {
					counter++;
				}	
			}
		}
		return counter;
	}
    public static void main(String[] args) {
    	TicTacToe tc = new TicTacToe();

    	tc.add(1);
    	tc.print();
    	tc.add(2);
    	tc.print();
    	tc.add(1);
    	tc.print();
    	tc.add(2);
    	tc.print();
    	tc.add(2);
    	tc.print();
    	tc.add(1);
    	tc.print();
    	tc.add(2);
    	tc.print();
    	tc.add(1);
    	tc.print();
    	tc.add(2);
    	tc.print();


    	System.out.println(tc.isFull());
    	System.out.println(tc.isValid());
	}
}
