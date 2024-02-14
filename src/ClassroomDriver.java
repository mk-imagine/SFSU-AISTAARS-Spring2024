import java.util.Scanner;

public class ClassroomDriver {
    public static void main(String[] args) {

        Classroom blakeslee = new Classroom();
        Classroom anotherClassroom = new Classroom();

        blakeslee.name = "Blakeslee Room";
        System.out.println(blakeslee.name);
        anotherClassroom.name = "This is another classroom";
        System.out.println(anotherClassroom.name);
        blakeslee.changeNumDesks();
        System.out.println(blakeslee.getNumDesks());
        blakeslee.changeNumDesks();
        System.out.println(blakeslee.getNumDesks());

        Scanner input = new Scanner(System.in);


    }
}