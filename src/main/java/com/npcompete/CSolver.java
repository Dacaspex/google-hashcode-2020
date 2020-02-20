package com.npcompete;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class CSolver {

    ArrayList<Book> books;
    ArrayList<Library> libraries;
    int b;
    int l;
    int d;

    PriorityQueue<Library> queue;


    public CSolver(ArrayList<Book> books, ArrayList<Library> libraries, int b, int l, int d) {
        this.books = books;
        this.libraries = libraries;
        this.b = b;
        this.l = l;
        this.d = d;
    }

    public Output solve() {
        Output output = new Output();

        HashSet<Book> scannedBooks = new HashSet<>();

        ArrayList<Library> sortedLibraries = new ArrayList<>(libraries);

        while (!sortedLibraries.isEmpty()) {
            sortedLibraries.sort(Comparator.comparingDouble(compLibrary -> {
                double totalScore = 0;

                for (int i = 0; i < compLibrary.books.size(); i++) {
                    if (!scannedBooks.contains(compLibrary.books.get(i))) {
                        totalScore += compLibrary.books.get(i).score;
                    }
                }

                return -((totalScore / 1.5) / (compLibrary.signup_time));
            }));

            Library library = sortedLibraries.get(0);

            OutputLibrary outLib = new OutputLibrary();
            outLib.library = library;
            outLib.scannedBooks = library.books;

            scannedBooks.addAll(library.books);

            output.outputLibraries.add(outLib);

            sortedLibraries.remove(0);
        }

        output.writeOutput();
        return output;
    }

}
