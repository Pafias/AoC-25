package me.pafias.aoc.day1.part2;

public enum Direction {

    LEFT,
    RIGHT;

    public static Direction parse(String input) {
        if (input == null || input.isEmpty()) return null;
        if (input.startsWith("L")) return LEFT;
        else if (input.startsWith("R")) return RIGHT;
        return null;
    }

}
