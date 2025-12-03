package me.pafias.aoc.day3.part2;

import lombok.Getter;

@Getter
public class Battery {

    private final String number;
    private final int numberAsInt;

    public Battery(String number){
        this.number = number;
        this.numberAsInt = Integer.parseInt(number);
    }

}
