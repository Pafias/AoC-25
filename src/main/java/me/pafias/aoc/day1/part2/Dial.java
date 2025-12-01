package me.pafias.aoc.day1.part2;

public class Dial {

    public int currentPosition = 50;

    public int zeroCount = 0;

    public void turn(Direction direction, int steps) {
        for (int i = 0; i < steps; i++) {

            if (direction == Direction.RIGHT)
                currentPosition++;
            else if (direction == Direction.LEFT)
                currentPosition--;

            if (currentPosition > 99)
                currentPosition = 0;
            else if (currentPosition < 0)
                currentPosition = 99;

            if (currentPosition == 0)
                zeroCount++;
        }
    }

}
