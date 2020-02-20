package com.npcompete;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ESolver {

    private final ArrayList<Book> books;
    private final ArrayList<Library> libraries;
    private final int b;
    private final int l;
    private final int d;

    public ESolver(ArrayList<Book> books, ArrayList<Library> libraries, int b, int l, int d) {
        this.books = books;
        this.libraries = libraries;
        this.b = b;
        this.l = l;
        this.d = d;

        Output output = new Output();

        for (Library lib : libraries) lib.books.sort(Comparator.comparingInt(book -> -book.libraries.size()));

        for (int day = 0; day < d + 10;) {
            final int finday = d - day;
            libraries.sort(Comparator.comparingDouble(library -> -eval(library, finday)));

            Library lib = libraries.get(0);
            libraries.remove(0);
            OutputLibrary outlib = new OutputLibrary();
            outlib.library = lib;
            outlib.scannedBooks = lib.books;
            output.outputLibraries.add(outlib);
            day += lib.signup_time;

            for (Book book : lib.books) {
                for (Library lib2 : book.libraries) {
                    if (lib2 == lib) continue;
                    lib2.books.remove(book);
                }
            }
        }
    }

    public double eval(Library lib, int remainingDays) {
        double score = 0;
        int i = 0;

        int d = lib.scan_capacity * (remainingDays - lib.signup_time);
        for (int j = 0; j < d && lib.books.size() > j; j++) {
            score += lib.books.get(i).score;
            i++;
        }

        return score / (double) lib.signup_time;
    }
}
