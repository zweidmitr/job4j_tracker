package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("it's not here");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Saturday", "Sunday"};
        int index = 0;
        try {
            index = indexOf(array, "Weekend+");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(index);
    }
}
