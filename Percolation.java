import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int gridSize;
    private final int VIRTUAL_TOP_ID;
    private final int VIRTUAL_BOT_ID;
    private boolean[] openSite;
    private final WeightedQuickUnionUF unitedSite;
    private final WeightedQuickUnionUF fullSite;
    private int numberOfOpenSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException();
        }
        gridSize = n;
        openSite = new boolean[n * n];
        unitedSite = new WeightedQuickUnionUF(n * n + 2);
        fullSite = new WeightedQuickUnionUF(n * n + 1);
        VIRTUAL_BOT_ID = getID(n, n) + 2;
        VIRTUAL_TOP_ID = getID(n, n) + 1;
    }

    private int getID(int row, int col) {
        isValid(row,col);
        return gridSize*(row - 1) + (col - 1);
    }
    private boolean isValid(int row, int col) {
        return row > 0 && col > 0 && row <= gridSize && col <= gridSize;
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        isValid(row, col);
        return openSite[getID(row,col)];
    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        isValid(row, col);

        if(isOpen(row, col)) {
            return;
        }
        int id = getID(row, col);
        openSite[id] = true;
        this.numberOfOpenSites++;

        if (row == 1) {
            unitedSite.union(VIRTUAL_TOP_ID, id);
            fullSite.union(VIRTUAL_TOP_ID, id);
        }

        if (row == gridSize) {
            unitedSite.union(VIRTUAL_BOT_ID, id);
        }

        if (isValid(row - 1, col) && isOpen(row - 1, col)) {
            unitedSite.union(getID(row - 1, col), id);
            fullSite.union(getID(row - 1, col), id);
        }

        if (isValid(row, col + 1) && isOpen(row, col + 1)) {
            unitedSite.union(getID(row, col + 1), id);
            fullSite.union(getID(row, col + 1), id);
        }

        if (isValid(row + 1, col) && isOpen(row + 1, col)) {
            unitedSite.union(getID(row + 1, col), id);
            fullSite.union(getID(row + 1, col), id);

        }

        if (isValid(row, col - 1) && isOpen(row, col - 1)) {
            unitedSite.union(getID(row, col - 1), id);
            fullSite.union(getID(row, col - 1), id);
        }

    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        isValid(row, col);
        int id = getID(row,col);
        return fullSite.connected(id,VIRTUAL_TOP_ID);
    }
    public boolean percolates() {
        return unitedSite.connected(VIRTUAL_TOP_ID,VIRTUAL_BOT_ID);
    }
    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }
    
    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation  = new Percolation(20);

    }



}
