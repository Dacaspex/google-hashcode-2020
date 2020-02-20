package com.npcompete;

import java.util.ArrayList;

public class OutputLibrary {

    Library library;
    ArrayList<Book> scannedBooks;

    public OutputLibrary() {
        scannedBooks = new ArrayList<>();
    }

    public OutputLibrary(Library library, ArrayList<Book> scannedBooks) {
        this.library = library;
        this.scannedBooks = scannedBooks;
    }

}
