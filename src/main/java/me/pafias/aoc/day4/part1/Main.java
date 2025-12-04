package me.pafias.aoc.day4.part1;

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
        final List<PaperRoll> accessibleRolls = tiles.stream()
                .filter(tile -> tile instanceof PaperRoll)
                .map(tile -> ((PaperRoll) tile))
                .filter(PaperRoll::isAccessible)
                .toList();

        System.out.println("Accessible rolls: " + accessibleRolls.size());
    }

}
