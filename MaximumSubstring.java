package com.xebia.training.dynamicProgramming;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class MaximumSubstring {
    CalculateSum calculateSum = new CalculateSum();

    public static void main(String[] args) {
        MaximumSubstring maximumSubstring = new MaximumSubstring();
        maximumSubstring.check();
    }


    public void check() {
        int[] numberList = new int[]{3,5,3,5,20};
        Optional<Map.Entry<String, Integer>> catchingArray = calculateSum.performAction(numberList);
        System.out.println(catchingArray);

    }


}


class CalculateSum {

    public Optional<Map.Entry<String, Integer>> performAction(int[] catchingArray) {
        //  3  ,  5 ,  3
        Map<String, Integer> objectHashSet = new LinkedHashMap<>();

        for (int i = 0; i <=catchingArray.length; i++) {
            for (int j = i + 2; j < catchingArray.length; j++) {

                String position = "{"+catchingArray[i] + "," + catchingArray[j]+"}";
                objectHashSet.put(position, Math.addExact(catchingArray[i], catchingArray[j]));
                break;
            }

        }
        return objectHashSet.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));

    }


}
