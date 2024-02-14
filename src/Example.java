public class Example {

    public static void main(String[] args) {
        Object[] arr = new Object[5];
        arr[0] = 5;
        arr[1] = 2.7;
        arr[2] = 'a';
        arr[3] = "Happy Halloween!";
        arr[4] = "last item";

        System.out.println("Observation -> What are the data types of the array elements?");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]: " + arr[i].getClass());
        }

    }
}
