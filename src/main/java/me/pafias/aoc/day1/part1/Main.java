package me.pafias.aoc.day1.part1;

import me.pafias.aoc.FileUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> lines = FileUtils.readFileAsLines("day1/input.txt");
        if (lines == null) throw new IllegalArgumentException("Failed to properly read input file.");

        Dial dial = new Dial();

        int zeroCount = 0;

        for (String line : lines) {
            Direction direction = Direction.parse(line);
            int steps = Integer.parseInt(line.substring(1));
            dial.turn(direction, steps);

            if (dial.currentPosition == 0)
                zeroCount++;
        }

        System.out.println("Final position: " + dial.currentPosition);
        System.out.println("Zero count: " + zeroCount);
    }

}
