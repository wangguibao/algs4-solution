/*
 * Solution to Exercise 1.4.10
 * 1.4.10 - Modify BinarySearch so that it always returns the element with the
 * smallest index that matches the search element (and still guarantees
 * logarithmic runnig time)
 */
import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = -1;
        int hi = a.length;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (key > a[mid]) {
                lo = mid;
            }
            else {
                hi = mid;
            }
        }
        
        return (hi < a.length && a[hi] == key) ? hi : -1;
    }
    
    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        for (int i = 0; i < whitelist.length; ++i) {
            StdOut.printf("%d - %d\n", i, whitelist[i]);
        }
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.println(rank(key, whitelist));
        }
    }
}
