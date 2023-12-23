package src;

import java.util.*;
import static java.lang.System.in;

public class Main{

    static Scanner scanner = new Scanner(in);

    public static void main(String[] args) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        while (true) {
            System.out.println("Чтобы добавить контакт введите: add \n" + "Чтобы вывести список контактов введите: print");
            String command = scanner.nextLine();
            if (command.equals("add")) {
                dataAdd(map);
            }
            else if (command.equals("print")) {
                dataPrint(map);
                break;
            }
            else {
                System.out.println("Вы ввели некорректную команду");
            }
        }
    }


    public static void dataAdd (HashMap<String, LinkedList<String>> map) {
        while (true) {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Вы ввели некорректное имя: ");
                continue;
            }
            else {
                System.out.println("Введите номер телефона: ");
                String number = scanner.nextLine();
                if (map.containsKey(name)) {
                    map.get(name).add(number);
                }
                else {
                    LinkedList<String> list = new LinkedList<>();
                    list.add(number);
                    map.put(name,list);
                }
            }
            break;
        }
    }

    public static void dataPrint (HashMap<String, LinkedList<String>> map) {

        for (Map.Entry<String, LinkedList<String>> el : map.entrySet()) {
            System.out.printf("%s : %s \n", el.getKey(), el.getValue());
        }
    }

}