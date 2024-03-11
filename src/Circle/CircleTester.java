package Circle;

public class CircleTester {
    public static void main(String[] args) {
        Circle a = new Circle();
        Circle b = new Circle(2, 2, 2);
        Circle c = new Circle(0, 3, 1);

        System.out.println(a.area());
        System.out.println(a.centerDistanceFrom(b));
        System.out.println(a.distanceFrom(c));
        System.out.println(a.intersects(b));
        System.out.println(a.sectorArea(Math.PI));
        System.out.println(a.getSmallest(b).radius);
        System.out.println(a.overlapAreaWith(b));
    }
}
