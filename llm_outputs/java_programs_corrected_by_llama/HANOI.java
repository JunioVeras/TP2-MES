package java_programs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HANOI {

    public static List<Pair<Integer, Integer>> hanoi(int height, int fromRod, int toRod) {
        ArrayList<Pair<Integer, Integer>> moves = new ArrayList<>();

        if (height == 0)
            return moves;

        PriorityQueue<Integer> availableRods = new PriorityQueue<>();
        for (int i = 1; i <= 3; i++)
            availableRods.add(i);

        availableRods.remove(fromRod);
        availableRods.remove(toRod);

        int nextAvailableRod = availableRods.poll();

        moves.addAll(hanoi(height - 1, fromRod, nextAvailableRod));

        moveDisk(moves, fromRod, toRod);

        moves.addAll(hanoi(height - 1, nextAvailableRod, toRod));

        return moves;
    }

    public static void moveDisk(ArrayList<Pair<Integer, Integer>> moves, int fromRod, int toRod) {
        moves.add(new Pair<>(fromRod, toRod));
    }

    public static class Pair<F, S> {
        private F first;
        private S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "(" + String.valueOf(first) + ", " + String.valueOf(second) + ")";
        }
    }
}