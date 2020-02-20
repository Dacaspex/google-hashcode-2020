package com.npcompete;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    int id;
    int signup_time;
    int scan_capacity;

    long sumOfScores() {
        long score = 0;
        for(Book book: books) {
            score += book.score;
        }
        return score;
    }
}
