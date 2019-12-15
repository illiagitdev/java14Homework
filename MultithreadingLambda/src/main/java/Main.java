package main.java;

import main.java.task1.Library;
import main.java.task2.LibraryDoor;

public class Main {
    public static void main(String[] args) {
        //перша частина завдання
//        Library library1 = Library.getInstance();
//        library1.run();

        //друга частина завдання з дверима
        LibraryDoor library2 = LibraryDoor.getInstance();
        library2.run();
    }
}
