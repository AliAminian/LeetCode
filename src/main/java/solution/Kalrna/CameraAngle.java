package solution.Kalrna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CameraAngle {
    public static void main(String[] args) {
        List<List<Integer>> points = List.of(List.of(2, 1), List.of(2, 2), List.of(3, 3));
        int angle = 90;
        List<Integer> location = List.of(1,1);
        int optimalAngle = visiblePoints(points, angle, location);
        System.out.println("Optimal Camera Angle: " + optimalAngle + " degrees");
    }

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int answer = 0;

        for (var point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);

            if (dx == 0 && dy == 0) {
                answer++;
                continue;
            }

            angles.add(Math.toDegrees(Math.atan2(dy, dx)));
        }

        Collections.sort(angles);

        /*
            -> Push angles again by adding 360 to handle the case of consecutive points
            being after a complete cycle.
            -> Example: -345 and 14 (if angle >= 29)
        */
        int n = angles.size();
        for (int i = 0; i < n; ++i) {
            angles.add(angles.get(i) + 360);
        }

        int start = 0;
        int count = 0;

        // Sliding window
        for (int end = 0; end < angles.size(); ++end) {
            while (angles.get(end) - angles.get(start) > angle) {
                start++;
            }

            count = Math.max(count, end - start + 1);
        }

        // adding the count to the number of overlapping points with the given location
        // computed earlier.
        answer += count;

        return answer;
    }
}
