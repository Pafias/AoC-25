package me.pafias.aoc.day1.part1;

public class Dial {

    public int currentPosition = 50;

    public void turn(Direction direction, int steps) {
        if (direction == Direction.LEFT) {
            for (int i = 0; i < steps; i++) {
                currentPosition--;
                if (currentPosition < 0)
                    currentPosition = 99;
            }
        } else if (direction == Direction.RIGHT) {
            for (int i = 0; i < steps; i++) {
                currentPosition++;
                if (currentPosition > 99)
                    currentPosition = 0;
            }
        }
    }

}
