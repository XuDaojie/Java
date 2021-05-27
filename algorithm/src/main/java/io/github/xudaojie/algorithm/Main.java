package io.github.xudaojie.algorithm;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author XuDaojie
 * @since 2021/5/17
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(1 + 2 + "3");
        System.out.println(1 + 2 + 3 + 4.0);

        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++)
        {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) c.increment();
            else                 p.draw();
        }

        StdOut.println(c);
        StdOut.println(box.area());


    }
}
