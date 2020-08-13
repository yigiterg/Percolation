import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
    private final int trials;
    private final int n;
    private final double[] perculationResults;
    private final static double DEV_CONSTANT = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if( n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        this.trials = trials;
        this.n = n;
        perculationResults = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while(!percolation.percolates()) {
                openRandomSite(percolation);
            }
            perculationResults[i] = (double) (percolation.numberOfOpenSites()) / (n*n);
        }

    }
    private void openRandomSite(Percolation percolation) {
        int row = 0;
        int col = 0;
        boolean exit = true;
        while(exit) {
            row = StdRandom.uniform(1, n + 1 );
            col = StdRandom.uniform(1, n + 1 );
            exit = percolation.isOpen(row, col);
        }
        percolation.open(row, col);


    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(perculationResults);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(perculationResults);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (DEV_CONSTANT * stddev() / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (DEV_CONSTANT * stddev() / Math.sqrt(trials));
    }

    // test client (see below)
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int trial = Integer.parseInt(args[1]);
        PercolationStats percolationStats = new PercolationStats(size, trial);
        System.out.println("mean:\t\t\t\t = " + percolationStats.mean());
        System.out.println("stddev:\t\t\t\t = " + percolationStats.stddev());
        System.out.println("95% confidence interval:\t = " + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi());
    }

}
