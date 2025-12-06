package me.pafias.aoc.day6.part1;

import me.pafias.aoc.FileUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final boolean useExample = false;

    public static void main(String[] args){
        List<String> lines = FileUtils.readFileAsLines("day6/" + (useExample ? "example.txt" : "input.txt"));
        if(lines == null)
            throw new IllegalArgumentException("Invalid input.");

        LinkedList<Problem> problems = new LinkedList<>();

        int problemIndex = 0;
        int numberIndex = 0;
        int lineSize = 1;
        while(numberIndex < lineSize || problems.stream().anyMatch(p -> p.getOperator() == null)) {
            for (String line : lines) {
                String[] split = Arrays.stream(line.split("\\s+")).filter(s -> !s.isBlank()).toList().toArray(new String[0]);
                lineSize = split.length;

                Problem problem;
                try {
                    problem = problems.get(problemIndex);
                } catch (IndexOutOfBoundsException ex) {
                    problem = new Problem();
                }

                final String currentThing = split[numberIndex];
                System.out.println("currentThing: " + currentThing);
                final long number;
                try {
                    number = Long.parseLong(currentThing);
                }catch(NumberFormatException ex){
                    assert problem != null;
                    // Operator
                    if(currentThing.equals("+")) {
                        problem.setOperator(Operator.ADD);
                        System.out.println("operator add set");
                    }else if(currentThing.equals("*")) {
                        problem.setOperator(Operator.MULTIPLY);
                        System.out.println("operator multiply set");
                    }
                    continue;
                }

                if(problem == null)
                    problem = new Problem();

                problem.getNumbers().add(number);

                try {
                    problems.set(problemIndex, problem);
                    System.out.println("set problemIndex " + problemIndex + " to problem " + problem);
                }catch(IndexOutOfBoundsException e){
                    System.out.println("add problemIndex " + problemIndex + " to problem " + problem);
                    problems.add(problemIndex, problem);
                }
            }
            numberIndex++;
            System.out.println("numberIndex: " + numberIndex);
            problemIndex++;
            System.out.println("problemIndex: " + problemIndex);
        }

        long total = 0;

        for(Problem problem : problems){
            System.out.println("PROBLEM: " + problem.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(" " + problem.getOperator().name() + " ")));
            long problemSolution = problem.getNumbers().getFirst();
            for(int i = 1; i < problem.getNumbers().size(); i++){
                final long number = problem.getNumbers().get(i);
                switch(problem.getOperator()){
                    case ADD:
                        problemSolution += number;
                        break;
                    case MULTIPLY:
                        problemSolution *= number;
                        break;
                }
                System.out.println(String.valueOf(problemSolution));
            }
            total += problemSolution;
        }

        System.out.println("Grand total: " + total + (useExample ? " Expected: 4277556" : ""));
    }

}
