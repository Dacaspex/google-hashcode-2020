package com.npcompete;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BSolver {
    public void test(List<Library> libraries, List<Book> books) {
        // all books are 100
        libraries.forEach(library -> {
            library.books.forEach(book -> {
                if (book.score != 100) {
                    System.out.println(book.id);
                }
            });

            // all libraries same books, same shipping time
            if (library.scan_capacity != 1) {
                System.out.println(library.id);
            }

            if (library.books.size() != 1000) {
                System.out.println(library.id);
            }
        });

        System.out.println("all good");
    }

    public Output solve(List<Library> libraries, List<Book> books) {
        // Sort libraries on increasing sign up time
        libraries.sort(Comparator.comparingInt(l -> l.signup_time));

        ArrayList<OutputLibrary> outputLibraries = new ArrayList<>();
        libraries.forEach(library -> {
            OutputLibrary lOut = new OutputLibrary(library, library.books);
            outputLibraries.add(lOut);
        });

        Output output = new Output(outputLibraries);
        output.writeOutput();

        return output;
    }
}
