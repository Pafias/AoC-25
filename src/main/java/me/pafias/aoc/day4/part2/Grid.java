package me.pafias.aoc.day4.part2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class Grid {

    private final Map<Coord, Tile> tiles = new HashMap<>();

    public Grid(List<String> list) {
        int y = 0;
        for (String line : list) {
            int x = 0;
            for (char c : line.toCharArray()) {
                final String character = Character.toString(c);
                if (character.equals("@")) {
                    tiles.put(new Coord(x, y), new PaperRoll(this, new Coord(x, y)));
                } else {
                    tiles.put(new Coord(x, y), new Tile(this, new Coord(x, y)));
                }
                x++;
            }
            y++;
        }
    }

    public Tile getTile(int x, int y) {
        return tiles.get(new Coord(x, y));
    }

    public void removePaperRoll(PaperRoll roll) {
        if (roll == null) return;
        tiles.put(roll.getCoord(), new Tile(this, roll.getCoord()));
    }


    @Getter
    @AllArgsConstructor
    public static class Coord {
        private int x;
        private int y;

        @Override
        public String toString() {
            return "{" + x + "," + y + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Coord c)
                return this.x == c.x && this.y == c.y;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
