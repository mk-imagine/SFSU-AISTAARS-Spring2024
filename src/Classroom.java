public class Classroom {

    public String name;
    private int numDesks;
    public int numChairs;
    public int numMonitors;

    public Classroom() {
        this.name = "default";
        this.numDesks = 0;
        this.numChairs = 0;
        this.numMonitors = 0;
    }

    public void changeNumDesks() {
        this.numDesks += 5;
    }

    public int getNumDesks() {
        return this.numDesks;
    }
}
