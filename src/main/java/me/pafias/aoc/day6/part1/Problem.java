package me.pafias.aoc.day6.part1;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Problem {

    private List<Long> numbers = new ArrayList<>();

    @Setter
    private Operator operator;

}
