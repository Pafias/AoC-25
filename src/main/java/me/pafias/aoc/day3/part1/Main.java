package me.pafias.aoc.day3.part1;

import me.pafias.aoc.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<String> banksList = FileUtils.readFileAsLines("day3/input.txt");
        if(banksList == null)
            throw new IllegalArgumentException("Invalid input file");

        final List<Bank> banks = new ArrayList<>();

        for(String bankString : banksList){
            final List<Battery> batteries = new ArrayList<>();
            for(char c : bankString.toCharArray()){
                String number = Character.toString(c);
                batteries.add(new Battery(number));
            }
            banks.add(new Bank(batteries));
        }

        int totalOutputJoltage = 0;
        for(Bank bank : banks){
            totalOutputJoltage += bank.getLargestPossibleJoltage();
        }

        System.out.println("Total output joltage: " + totalOutputJoltage);
    }

}
