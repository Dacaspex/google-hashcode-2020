package com.npcompete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BSolver {

    public static void main(String[] args) {
        Library l1 = new Library();
        l1.signup_time = 1;
        l1.id = 1;

        Library l2 = new Library();
        l2.signup_time = 5;
        l2.id = 2;

        Library l3 = new Library();
        l3.signup_time = 5;
        l3.id = 3;

        ArrayList<Library> test = new ArrayList<>(Arrays.asList(
                l1, l2, l3
        ));

        solve(test, new ArrayList<>());
    }

    public static void solve(List<Library> libraries, List<Book> books) {
        // Sort libraries on increasing sign up time
        libraries.sort(Comparator.comparingInt(l -> l.signup_time));

        ArrayList<OutputLibrary> outputLibraries = new ArrayList<>();
        libraries.forEach(library -> {
            OutputLibrary lOut = new OutputLibrary(library, library.books);
            outputLibraries.add(lOut);
        });

        Output output = new Output(outputLibraries);
        output.writeOutput();
    }
}
