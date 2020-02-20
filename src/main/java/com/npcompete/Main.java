package com.npcompete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Library> libraries = new ArrayList<>();
    int B;
    int L;
    int D;
    long best;

    public Main(char input, long best) {
        parseIntput(input);
        this.best = best;
    }

    public long run() {
        ESolver s = new ESolver(books, libraries, B, L, D);
        long score = s.output.calculateScore(D);
        if (score > best) {
            s.output.writeOutput();
            return score;
        }
        return best;
    }

    void parseIntput(char input){
        libraries = new ArrayList<>();
        books = new ArrayList<>();

        File file = null;
        switch(input) {
            case 'a':
                file = new File("./input/a_example.txt");
                break;
            case 'b':
                file = new File("./input/b_read_on.txt");
                break;
            case 'c':
                file = new File("./input/c_incunabula.txt");
                break;
            case 'd':
                file = new File("./input/d_tough_choices.txt");
                break;
            case 'e':
                file = new File("./input/e_so_many_books.txt");
                break;
            case 'f':
                file = new File("./input/f_libraries_of_the_world.txt");
                break;
        }

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        B = sc.nextInt();
        L = sc.nextInt();
        D = sc.nextInt();

        for (int i = 0; i < B; i++) {
            Book book = new Book();
            book.id = i;
            book.score = sc.nextInt();
            books.add(book);
        }

        for (int i = 0; i < L; i++) {
            Library library = new Library();
            int N = sc.nextInt();
            library.id = i;
            library.signup_time = sc.nextInt();
            library.scan_capacity = sc.nextInt();
            for (int j = 0; j < N; j++) {
                Book book = books.get(sc.nextInt());
                book.libraries.add(library);
                library.books.add(book);
            }
            libraries.add(library);
        }
    }

    public static void main(String[] args) {
        long best = 0;
        int i = 0;
        while (i < 100) {
            best = new Main('e', best).run();
            i++;
            System.out.println(best);
        }

    }
}
