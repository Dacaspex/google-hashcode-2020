package com.npcompete;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BSolver {
    public void solve(List<Library> libraries, List<Book> books) {
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
