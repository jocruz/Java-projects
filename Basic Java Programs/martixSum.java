public class martixSum {

	public static void main(String[] args) {
		
	}

	public static int[][] sum(int[][] a, int[][] b) {
		int[][] c = new int[a.length][a[1].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

}
