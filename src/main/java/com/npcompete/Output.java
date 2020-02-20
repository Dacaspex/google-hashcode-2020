package com.npcompete;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Output {

    ArrayList<OutputLibrary> outputLibraries;

    public Output() {
        outputLibraries = new ArrayList<>();
    }

    public Output(ArrayList<OutputLibrary> outputLibraries) {
        this.outputLibraries = outputLibraries;
    }

    public void writeOutput() {
        try {
            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");

            // Line containing the number of libraries to sign up (A)
            writer.println(outputLibraries.size());

            // Lines containing libraries in order of signup
            for (int i = 0; i < outputLibraries.size(); i++) {
                OutputLibrary outputLibrary = outputLibraries.get(i);

                // Print ID of library (Y) and number of books to be scanned (K)
                writer.println(outputLibrary.library.id + " " + outputLibrary.scannedBooks.size());

                // Print list of scanned books
                StringBuilder sb = new StringBuilder("" + outputLibrary.scannedBooks.get(0).id);
                for (int j = 1; j < outputLibrary.scannedBooks.size(); j++) {
                    sb.append(" ").append(outputLibrary.scannedBooks.get(j).id);
                }

                writer.println(sb.toString());
            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public long calculateScore(long totalDays) {
        long score = 0;

        long currentDay = 0;
        for(OutputLibrary lib : outputLibraries) {
            currentDay += lib.library.signup_time;
            if (currentDay >= totalDays) break;

            long daysLeft = totalDays - currentDay;

            // some books may be scheduled only after the deadline
            long numBooksScannable = Math.min(lib.scannedBooks.size(), daysLeft * lib.library.scan_capacity);

            for(int i = 0; i < lib.scannedBooks.size(); i++) {
                if(i >= numBooksScannable) break;
                score += lib.scannedBooks.get(i).score;
            }
        }

        return score;
    }

}
