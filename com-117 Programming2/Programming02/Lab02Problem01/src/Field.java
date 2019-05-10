
public class Field {
	private int h;
	private int w;
	private char[][] data;
	
	public Field(int aH, int aW) {
		h = aH;
		w = aW;
		data = new char[h][w];
		for (int i = 0; i<h; ++i) {
			for (int j = 0; j<w; ++j) {
				data[i][j] = '.';
			}
		}
	}

	public void show() {
		for (int i = 0; i<h; ++i) {
			for (int j = 0; j<w; ++j) {
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}

	public void fill(int row, int col, char c) {
		data[row][col] = c;
	}
}
