import java.util.Scanner;

public class LaunchHashTable {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Введите размер таблицы");
        int tableLength = reader.nextInt();

        System.out.println("Введите максим. размер списка");
        int listElemCount = reader.nextInt();

        MyHashTable table = new MyHashTable(tableLength, listElemCount);
    }
}
