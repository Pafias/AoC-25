package me.pafias.aoc.day4.part2;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class PaperRoll extends Tile {

    public PaperRoll(Grid grid, Grid.Coord coord) {
        super(grid, coord);
    }

    public boolean isAccessible() {
        final Set<Tile> adjacent = getAdjacentTiles();
        return adjacent.stream().filter(tile -> (tile instanceof PaperRoll)).count() < 4;
    }

    public Set<Tile> getAdjacentTiles() {
        Set<Tile> list = new HashSet<>();

        list.add(grid.getTile(coord.getX() - 1, coord.getY() - 1)); // Top left
        list.add(grid.getTile(coord.getX(), coord.getY() - 1)); // Top middle
        list.add(grid.getTile(coord.getX() + 1, coord.getY() - 1)); // Top right

        list.add(grid.getTile(coord.getX() - 1, coord.getY())); // Left
        list.add(grid.getTile(coord.getX() + 1, coord.getY())); // Right

        list.add(grid.getTile(coord.getX() - 1, coord.getY() + 1)); // Bottom left
        list.add(grid.getTile(coord.getX(), coord.getY() + 1)); // Bottom middle
        list.add(grid.getTile(coord.getX() + 1, coord.getY() + 1)); // Bottom right

        return list;
    }

}
