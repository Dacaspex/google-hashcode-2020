package com.npcompete;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DGreedySolver {

    private final ArrayList<Book> books;
    private final ArrayList<Library> libraries;
    private final int b;
    private final int l;
    private final int d;

    PriorityQueue<Library> queue;


    public DGreedySolver(ArrayList<Book> books, ArrayList<Library> libraries, int b, int l, int d) {
        this.books = books;
        this.libraries = libraries;
        this.b = b;
        this.l = l;
        this.d = d;

        Output output = new Output();

        queue = new PriorityQueue<>(libraries.size(), Comparator.comparingInt(library -> -library.books.size()));
        queue.addAll(libraries);

        while (!queue.isEmpty() && queue.peek().books.size() > 0){
            Library library = queue.poll();
            OutputLibrary outLib = new OutputLibrary();
            outLib.library = library;
            outLib.scannedBooks = library.books;

            for (Book book : library.books) {
                for (Library lib : book.libraries) {
                    if (lib == library) continue;
                    lib.books.remove(book);
                    queue.remove(lib);
                    queue.add(lib);
                }
            }

            output.outputLibraries.add(outLib);
        }
        output.writeOutput();
    }
}
