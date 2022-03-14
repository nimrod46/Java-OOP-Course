package Lab02;

public class Table {

    private final int[][] table;
    private final int width;
    private final int height;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
        table = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                table[i][j] = i * j;
            }
        }
    }

    public void display(int width, int height) {
        display(1, width, 1, height);
    }

    public void display(int fc, int tc, int fr, int tr) {
        System.out.printf("Multiplication Table ([%d..%d]x[%d..%d])\n", fc, tc, fr, tr);
        System.out.println();
        System.out.print("      ");
        for (int j = fc; j <= tc; j++) {
            System.out.printf("%6d", j);
        }
        System.out.println();
        for (int i = fr; i <= tr; i++) {
            System.out.printf("%6d", i);
            for (int j = fc; j <= tc; j++) {
                System.out.printf("%6d", table[i][j]);
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
