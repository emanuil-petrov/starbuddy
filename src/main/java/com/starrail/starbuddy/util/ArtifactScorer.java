package com.starrail.starbuddy.util;

import java.util.ArrayList;
import java.util.List;

public class ArtifactScorer {
    public List<Double> findClosestCombination(double target, List<Double> numbers) {
        List<Double> closestCombination = new ArrayList<>();
        double minDiff = Double.MAX_VALUE;

        for (int i = 0; i <= target / numbers.get(0); i++) {
            for (int j = 0; j <= target / numbers.get(1); j++) {
                for (int k = 0; k <= target / numbers.get(2); k++) {
                    double sum = i * numbers.get(0) + j * numbers.get(1) + k * numbers.get(2);
                    double diff = Math.abs(sum - target);

                    if (diff < minDiff && sum <= target) {
                        minDiff = diff;
                        closestCombination.clear();
                        for (int x = 0; x < i; x++) {
                            closestCombination.add(numbers.get(0));
                        }
                        for (int y = 0; y < j; y++) {
                            closestCombination.add(numbers.get(1));
                        }
                        for (int z = 0; z < k; z++) {
                            closestCombination.add(numbers.get(2));
                        }
                    }
                }
            }
        }

        return closestCombination;
    }

    public void printCombination(List<Double> closestCombination) {
        System.out.println("Closest combination:");
        for (double num : closestCombination) {
            System.out.print(num + " ");
        }
    }
}
