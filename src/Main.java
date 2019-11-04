public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(4,100);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(8);
        System.out.println(arr);

    }
}
