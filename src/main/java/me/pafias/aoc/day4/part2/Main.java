package me.pafias.aoc.day4.part2;

import me.pafias.aoc.FileUtils;

import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> lines = FileUtils.readFileAsLines("day4/input.txt");
        if (lines == null)
            throw new IllegalArgumentException("Invalid input");

        final Grid grid = new Grid(lines);
        final Collection<Tile> tiles = grid.getTiles().values();

        List<PaperRoll> accessibleRolls = tiles.stream()
                .filter(tile -> tile instanceof PaperRoll)
                .map(tile -> ((PaperRoll) tile))
                .filter(PaperRoll::isAccessible)
                .toList();

        int removed = 0;
        while (!accessibleRolls.isEmpty()) {
            for (PaperRoll roll : accessibleRolls) {
                grid.removePaperRoll(roll);
                removed++;
            }
            accessibleRolls = tiles.stream()
                    .filter(tile -> tile instanceof PaperRoll)
                    .map(tile -> ((PaperRoll) tile))
                    .filter(PaperRoll::isAccessible)
                    .toList();
        }

        System.out.println("Removed rolls: " + removed);
    }

}
