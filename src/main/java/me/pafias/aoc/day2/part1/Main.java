package me.pafias.aoc.day2.part1;

import me.pafias.aoc.FileUtils;

public class Main {

    public static void main(String[] args){
        String input = FileUtils.readFileAsString("day2/input.txt");

        long sum = 0;

        String[] ranges = input.split(",");
        for(String range : ranges){
            long min = Long.parseLong(range.split("-")[0]);
            long max = Long.parseLong(range.split("-")[1]);
            for(long id = min; id <= max; id++){
                if(isInvalid(id))
                    sum += id;
            }
        }

        System.out.println("Sum of all invalid IDs: " + sum);
    }

    private static boolean isInvalid(long id){
        boolean valid = true;

        final String idString = String.valueOf(id);
        final String firstHalf = idString.substring(0, idString.length() / 2);
        final String secondHalf = idString.substring(idString.length() / 2);
        if(firstHalf.equals(secondHalf))
            valid = false;

        return !valid;
    }

}
