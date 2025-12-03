package me.pafias.aoc.day3.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Bank {

    private List<Battery> batteries;

    public int getLargestPossibleJoltage(){
        Battery largestBattery = batteries.getFirst();
        int largestNumberIndex = batteries.getFirst().getNumberAsInt();
        for(int i = 0; i < batteries.size() - 1; i++){
            final Battery battery = batteries.get(i);
            if(battery.getNumberAsInt() > largestBattery.getNumberAsInt()){
                largestBattery = battery;
                largestNumberIndex = batteries.indexOf(battery);
            }
        }

        Battery secondLargestBattery = null;
        for(int i = Math.min(largestNumberIndex + 1, batteries.size()); i < batteries.size(); i++){
            final Battery battery = batteries.get(i);
            if(secondLargestBattery == null || battery.getNumberAsInt() > secondLargestBattery.getNumberAsInt()) {
                secondLargestBattery = battery;
            }
        }

        return Integer.parseInt(largestBattery.getNumber() + secondLargestBattery.getNumber());
    }

}
