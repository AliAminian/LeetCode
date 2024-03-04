package solution.immoscout;

import java.util.*;

/*
A covert agent has some crucial information stored in the form of an array of integers. The array contains sensitive information and it must not be revealed to anyone. However, there are few things about the array which are known.
An array is said to be analogous to the secret array if all of the following conditions are true:
• The length of the array is equal to the length of the secret array.
• Each integer in the array lies in the interval [lowerBound, upperBound].
• The difference between each pair of consecutive integers of the array must be equal to the difference between the respective pair of consecutive integers in the secret array. In other words, let the secret array be [s[0], s[1],...s[n-1JJand let the analogous array be [a[0] a[1]....an-117, then (a[i-1] - a[i]) must be equal to (s[i-1] - s[i]) for each i from 1 to n-1.
Given the value of the integers lowerBound and upperBound, inclusive, and the array of differences between each pair of consecutive integers of the secret array, find the number of arrays that are analogous to the secret array. If there is no array analogous to the secret array, return 0.
For example:
consecutiveDifference = [-2, -1, -2, 5]
lowerBound=3
upperBound=10
The logic to create an analogous array starting from the lower bound is:
Start with a value of 3.
Subtract consecutiveDistances [0], 3 - (-2) = 5
Subtract consecutiveDistances [11. 5 - (-1) = 6
Subtract consecutiveDistances [2], 6 - (-2) = 8
Subtract consecutiveDistances [31, 8 - 5 = 3
Note that none of the values is out of bounds. All possible analogous arrays are:
[3, 5, 6, 8, 3]
[4, 6, 7, 9, 4]
[5, 7, 8, 10, 5]
The answer is 3.


 */
public class Result {
    private static int count = 0;

    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
        for (int i = lowerBound; i <= upperBound; i++) {
            List<Integer> condidates = new ArrayList<>();
            condidates.add(i);
            int counter = 0;
            for (int j = 0; j < consecutiveDifference.size() ; j++) {
                int newVal = condidates.get(counter) - consecutiveDifference.get(j);
                if (lowerBound <= newVal && newVal <= upperBound) {
                    condidates.add(newVal);
                    counter++;
                }
            }
            if (condidates.size() == consecutiveDifference.size()+1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> consecutiveDifference = List.of(-2, -1, -2, 5);
        int lowerBound = 3;
        int upperBound = 10;

        int result = countAnalogousArrays(consecutiveDifference, lowerBound, upperBound);
        System.out.println("Number of analogous arrays: " + result);
    }
}


