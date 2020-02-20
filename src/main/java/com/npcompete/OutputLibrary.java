package com.npcompete;

import java.util.ArrayList;

public class OutputLibrary {

    ArrayList<Book> scannedBooks;

    public OutputLibrary() {
        scannedBooks = new ArrayList<>();
    }

    public OutputLibrary(ArrayList<Book> scannedBooks) {
        this.scannedBooks = scannedBooks;
    }

}
