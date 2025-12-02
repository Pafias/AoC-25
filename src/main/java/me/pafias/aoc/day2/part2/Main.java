package me.pafias.aoc.day2.part2;

import me.pafias.aoc.FileUtils;

import java.util.HashMap;
import java.util.Map;

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

        final Map<String, Integer> occurrences = new HashMap<>();

        final String idString = String.valueOf(id);

        for(int length = 1; length < idString.length(); length++){
            String substr = idString.substring(0, length);
            occurrences.put(substr, occurrences.getOrDefault(substr, 0) + 1);
        }

        StringBuilder s = new StringBuilder();
        for(Map.Entry<String, Integer> entry : occurrences.entrySet()){
            while(s.length() < idString.length()){
                s.append(entry.getKey());
            }
            if(s.toString().equals(idString)) {
                valid = false;
                break;
            }
            s = new StringBuilder();
        }

        if(occurrences.values().stream().anyMatch(x -> x > 1)) valid = false;

        return !valid;
    }

}
