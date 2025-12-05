package me.pafias.aoc.day5.part1;

import me.pafias.aoc.FileUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> lines = FileUtils.readFileAsLines("day5/input.txt");
        if (lines == null)
            throw new IllegalArgumentException("Invalid input.");

        int blankLineIndex = lines.indexOf("");

        Set<Range> freshRanges = new HashSet<>();

        for (int i = 0; i < blankLineIndex; i++) {
            final String line = lines.get(i);
            final String[] range = line.split("-");
            final long start = Long.parseLong(range[0]);
            final long end = Long.parseLong(range[1]);
            freshRanges.add(new Range(start, end));
        }

        int freshCount = 0;

        for (int i = blankLineIndex + 1; i < lines.size(); i++) {
            final String line = lines.get(i);
            final Long ingredient = Long.parseLong(line);
            if (freshRanges.stream().anyMatch(range -> range.isWithin(ingredient)))
                freshCount++;
        }

        System.out.println("There are " + freshCount + " fresh ingredients!");
    }

}
