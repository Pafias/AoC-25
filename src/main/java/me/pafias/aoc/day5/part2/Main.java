package me.pafias.aoc.day5.part2;

import me.pafias.aoc.FileUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final List<String> lines = FileUtils.readFileAsLines("day5/input.txt");
        if (lines == null)
            throw new IllegalArgumentException("Invalid input.");

        final int blankLineIndex = lines.indexOf("");

        final Set<Range> freshRanges = new HashSet<>();

        for (int i = 0; i < blankLineIndex; i++) {
            final String line = lines.get(i);
            final String[] range = line.split("-");
            final long start = Long.parseLong(range[0]);
            final long end = Long.parseLong(range[1]);
            freshRanges.add(new Range(start, end));
        }

        final long lowestId = freshRanges.stream().mapToLong(Range::getStart).min().getAsLong();
        final long highestId = freshRanges.stream().mapToLong(Range::getEnd).min().getAsLong();

        final Set<Long> fresh = new HashSet<>();
        for (long i = lowestId; i <= highestId; i++) {
            if (fresh.contains(i)) continue;
            for (final Range freshRange : freshRanges) {
                if (freshRange.isWithin(i)) {
                    fresh.add(i);
                    break;
                }
            }
        }

        System.out.println("There are " + fresh.size() + " fresh ingredients!");
    }

}
