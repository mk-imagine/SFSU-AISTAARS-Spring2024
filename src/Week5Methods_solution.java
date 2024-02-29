public class Week5Methods_solution {

    /*
    Create the following methods and a set of tests in the main method to test your methods:

    pointDistance - this method should take in two x,y coordinate points and calculate the distance between the two.

    circlesIntersect - this method should take in two x,y coordinate points and two r radius values and return whether
    the two circles intersect.

    circleDistance - this method should take in two x,y coordinate points and two r radius values and calculate the
    distance between the exteriors of two circles
    EXAMPLE: If circle1 has x1 = 0, y1 = 0, r1 = 1 and circle2 has x2 = 5, y1 = 0, r2 = 2, this function should return
    a distance of 2.

    circleArea - this method should take in a radius and return the area of the circle.

    circleSector - this method should take in a radius and an angle (in degrees or radians -- be sure to be clear which
    you use) and returns the area of the sector (the sector is the pie shaped part of a circle formed by the angle).

    *** BONUS ***

    overlapArea - this method should take in the radius and coordinates of two circles and calculate the area overlap
    between the two.


    --- MORE BONUS ---

    Create methods that will to the same thing, but for squares (with sides parallel and perpendicular to the axes).
    How are you going to define your squares?
    Depending on how you define your squares, you may need a method that verifies if what you provided actually *IS* a
    square.  If so, create this method.
    Still not enough?  Create methods for squares in any orientation.


    === SOME USEFUL FORMULAE ===
    Area of a circle : pi * r^2
    Distance between two points : sqrt( (x2 - x1)^2 + (y2 - y1)^2 )

     */
    
    public static double pointDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt( Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean circlesIntersect(double x1, double y1, double r1, double x2, double y2, double r2) {
        return pointDistance(x1, y1, x2, y2) < r1 + r2;
    }

    public static double circleDistance(double x1, double y1, double r1, double x2, double y2, double r2) {
        return pointDistance(x1, y1, x2, y2) - (r1 + r2);
    }

    public static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // Angle in radians
    public static double circleSector(double radius, double angle) {
        return circleArea(radius) * angle / (2 * Math.PI);
    }

    public static double circleOverlapArea(double x1, double y1, double r1, double x2, double y2, double r2) {
        double d = circleDistance(x1, y1, r1, x2, y2, r2);
        if (d > 0) {
            return 0;
        }

        double d1 = (r1 * r1 - r2 * r2 + d * d) / (2 * d);
        double d2 = (r2 * r2 - r1 * r1 + d * d) / (2 * d);

        double c1halfangle = Math.acos(d1 / r1);
        double c2halfangle = Math.acos(d2 / r2);

        double c1segment = r1 * r1 * c1halfangle - d1 * Math.sqrt(r1 * r1 - d1 * d1);
        double c2segment = r2 * r2 * c2halfangle - d2 * Math.sqrt(r2 * r2 - d2 * d2);

        return c1segment + c2segment;
    }

    public static void main(String[] args) {

        // Initialize some variables to test methods
        // To make it easier to follow the variables and to automate the tests,
        // I put the values into a 2d array with the following layout:
        // { {x1, y1, r1}, {x2, y2, r2}, ... , {xn, yn, rn} }
        double[] c1 = {0, 0, 1};
        double[] c2 = {3.2, 4.3, 2.2};
        double[] c3 = {4.5, 2.6, 1.8};
        double[] c4 = {-5, 9, 6};
        double[][] c = {c1, c2, c3, c4};
        double[] pointAns = {0, 5.360, 5.197, 10.296, 0, 2.140, 9.451, 0, 11.455, 0};
        boolean[] intersectAns = {true, true, true, true, true, true, true, true, true, true};

        // POINT DISTANCE TESTS
        System.out.println("pointDistance():");
        System.out.println("  eval pair  actual  expected");
        int ansIdx = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                System.out.printf("   c%d - c%d : %6.3f   %6.3f\n", 
                                  i, 
                                  j,
                                  pointDistance(c[i][0], c[i][1], c[j][0], c[j][1]),
                                  pointAns[ansIdx++]);
            }
        }

        // CIRCLES INTERSECT TESTS
        System.out.println("circlesIntersect():");
        System.out.println("  eval pair  actual   expected");
        ansIdx = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = i; j < c.length; j++) {
                System.out.printf("   c%d - c%d : %6B   %6B\n", 
                                  i, 
                                  j,
                                  circlesIntersect(c[i][0], c[i][1], c[i][2], c[j][0], c[j][1], c[j][2]),
                                  intersectAns[ansIdx++]);
            }
        }
    }

}
