package me.pafias.aoc.day5;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Range {

    private long start;
    private long end;

    public boolean isWithin(Long ingredient) {
        return ingredient >= start && ingredient <= end;
    }

}
