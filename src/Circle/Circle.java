package Circle;

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle() {
        x = 0;
        y = 0;
        radius = 1;
    }

    public Circle(double x, double y, double r){
        this.x = x;
        this.y = y;
        radius = r;
    }

    public double centerDistanceFrom(Circle a) {
        return Math.sqrt( Math.pow(this.x - a.x, 2) + Math.pow(this.y - a.y, 2));
    }

    public boolean intersects(Circle a) {
        return centerDistanceFrom(a) < this.radius + a.radius;
    }

    public double distanceFrom(Circle a) {
        return this.centerDistanceFrom(a) - (this.radius + a.radius);
    }

    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    // Angle in radians
    public double sectorArea(double angle) {
        return this.area() * angle / (2 * Math.PI);
    }

    public Circle getSmallest(Circle a) {
        if (this.radius < a.radius) {
            return this;
        } else {
            return a;
        }
//        // Alternatively...
//        return this.radius < a.radius ? this : a;
    }

    public double overlapAreaWith(Circle a) {
        double d = centerDistanceFrom(a);

        if (d > this.radius + a.radius) {
            return 0;
        } else if (d < Math.min(this.radius, a.radius)) {
            return this.getSmallest(a).area();
        }

        double d1 = (this.radius * this.radius - a.radius * a.radius + d * d) / (2 * d);
        double d2 = d - d1;

        double c1halfangle = Math.acos(d1 / this.radius);
        double c2halfangle = Math.acos(d2 / a.radius);

        double c1segment = this.radius * this.radius * (c1halfangle - Math.sin(c1halfangle));
        double c2segment = a.radius * a.radius * (c2halfangle - Math.sin(c2halfangle));

        return c1segment + c2segment;
    }


}
