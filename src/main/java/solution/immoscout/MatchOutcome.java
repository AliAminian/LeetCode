package solution.immoscout;

import java.util.*;

/*
Given the initial setup of a match between two players, evaluate the match's outcome.
There are two players, and there is a number sequence of size n. Players alternate turns for rounds. Each round, a player removes the first number from the sequence and adds its value to their score. After that, if the 'removed' number is even, the remaining sequence is reversed.
Determine the difference in scores between the two players after the game.
More precisely, suppose first score and second score are the final scores of the first and second player, respectively. The goal is to calculate the value of first_score - second_score.
Example
The number of elements is n = 5 and numSeq = [3, 6, 2, 3, 5].
• 1st round: The first player picks 3, first_score = 3. The remaining sequence: [6, 2, 3, 5].
• 2nd round: The second player picks 6, second score = 6. Since 6 is even, the remaining sequence is reversed: [5, 3, 2].
• 3/ round: The first player picks 5, first_score = 3 + 5 = 8. The remaining sequence: [3, 2].
• 4th round: Second player picks 3, second score = 6 + 3 = 9. The remaining sequence: [2].
• 5th round (final): First player picks 2, second score = 8 + 2 = 10. The remaining sequence: D.
The total difference between players' scores is first_ score - second score = 10 - 9 = 1.
 */
public class MatchOutcome {
    public static int getScoreDifference(List<Integer> numSeq) {
        int firstScore = 0;
        int secondScore = 0;

        List<Integer> rev = new ArrayList<>(numSeq);
        Collections.reverse(rev);

        for (int i = 0; i < numSeq.size(); i++) {
            if (i % 2 == 0) {
                firstScore += numSeq.get(i);
            } else {
                secondScore += numSeq.get(i);
            }
            if (numSeq.get(i) %2 ==0) numSeq = rev;
        }

        return firstScore - secondScore;
    }


    public static void main(String[] args) {
        List<Integer> numSeq = List.of(3, 6, 2, 3, 5);

        int result = getScoreDifference(numSeq);
        System.out.println("Difference in scores: " + result);
    }
}
