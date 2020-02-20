package com.npcompete;

import java.util.ArrayList;

public class InputPrint {

    int days;
    ArrayList<Book> books;
    ArrayList<Library> libraries;

    boolean printBooks = true;
    boolean printLibraries = true;
    boolean printBooksOfLibraries = true;

    public InputPrint(int days, ArrayList<Book> books, ArrayList<Library> libraries) {
        this.days = days;
        this.books = books;
        this.libraries = libraries;
    }

    public void Print() {
        System.out.println("Number of days: " + days);
        System.out.println("Number of books: " + books.size());
        System.out.println("Number of libraries: " + libraries.size());

        if (printLibraries) {
            System.out.println("Libraries:");
            for (int i = 0; i < libraries.size(); i++) {
                Library library = libraries.get(i);
                System.out.println("    #" + i + " signup: " + library.signup_time + " scanCap: " + library.scan_capacity);

                if (printBooksOfLibraries) {
                    System.out.println("    Books:");
                    for (int j = 0; j < library.books.size(); j++) {
                        System.out.println("        #" + j + " score: " + library.books.get(j).score);
                    }
                }
            }
        }

        if (printBooks) {
            System.out.println("Books:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println("    #" + i + " score: " + books.get(i).score);
            }
        }
    }
}
