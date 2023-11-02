package com.comp3607project;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class CosineSimilarity implements PlagiarismChecker {

    public double measure(AssignmentSubmission as1, AssignmentSubmission as2) {

        // Placeholder strings for now
        String s1 = "";
        String s2 = "";

        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        Set<String> uniqueWords = new HashSet<>();
        for (String word : words1) {
            uniqueWords.add(word);
        }
        for (String word : words2) {
            uniqueWords.add(word);
        }

        Map<String, Integer> tf1 = new HashMap<>();
        Map<String, Integer> tf2 = new HashMap<>();
        for (String word : uniqueWords) {
            tf1.put(word, termFrequency(word, words1));
            tf2.put(word, termFrequency(word, words2));
        }

        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        for (String word : uniqueWords) {
            dotProduct += tf1.get(word) * tf2.get(word);
            magnitude1 += tf1.get(word) * tf1.get(word);
            magnitude2 += tf2.get(word) * tf2.get(word);
        }

        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0;
        } else {
            return dotProduct / (Math.sqrt(magnitude1) * Math.sqrt(magnitude2));
        }
    }

    private static int termFrequency(String term, String[] words) {
        int count = 0;
        for (String word : words) {
            if (term.equals(word)) {
                count++;
            }
        }
        return count;
    }

}
