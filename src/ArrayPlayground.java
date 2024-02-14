public class ArrayPlayground {
    public static void main(String []args) {
        Object[] array = new Object[15];

        for (int i = 0; i < array.length; i++) {
            array[i] = (i + 1) * 2;

            System.out.print(array[i] + " ");
        }
    }
}