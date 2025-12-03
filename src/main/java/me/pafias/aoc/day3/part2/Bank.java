package me.pafias.aoc.day3.part2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@AllArgsConstructor
public class Bank {

    private List<Battery> batteries;

    public long getLargestPossibleJoltage(){
        List<Battery> pastBatteries = new ArrayList<>();
        while(pastBatteries.size() < 12)
        for(int i = 0; i < batteries.size(); i++){
            final Battery battery = batteries.get(i);
            if(pastBatteries.isEmpty()) {
                pastBatteries.add(battery);
                continue;
            }
            final List<Battery> nextBatteries = new ArrayList<>();
            for(Battery b : batteries){
                if(!pastBatteries.contains(b))
                    nextBatteries.add(b);
            }
            if(!nextBatteries.stream().anyMatch(b -> b.getNumberAsInt() > battery.getNumberAsInt())){
                pastBatteries.add(battery);
                break;
            }
            if(battery.getNumberAsInt() > pastBatteries.stream().max(Comparator.comparingInt(b -> b.getNumberAsInt())).get().getNumberAsInt()){
                pastBatteries.add(battery);
            }
        }

        final StringBuilder sb = new StringBuilder();
        for(Battery b : pastBatteries){
            sb.append(b.getNumber());
        }
        return Long.parseLong(sb.toString());
    }

}
