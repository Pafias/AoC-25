package me.pafias.aoc.day4.part1;

import lombok.Getter;

@Getter
public class Tile {

    protected Grid grid;
    protected Grid.Coord coord;

    public Tile(Grid grid, Grid.Coord coord) {
        this.grid = grid;
        this.coord = coord;
    }

}
