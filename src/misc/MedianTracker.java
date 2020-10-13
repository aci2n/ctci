package misc;

import java.util.PriorityQueue;

public class MedianTracker {
    PriorityQueue<Integer> highers;
    PriorityQueue<Integer> lowers;

    MedianTracker() {
        highers = new PriorityQueue<>((a, b) -> a - b);
        lowers = new PriorityQueue<>((a, b) -> b - a);
    }

    void checkBalance(PriorityQueue<Integer> bigger, PriorityQueue<Integer> smaller) {
        if (bigger.size() > smaller.size() + 1) {
            smaller.add(bigger.remove());
        }
    }

    void track(int value) {
        if (highers.isEmpty() || value < highers.peek()) {
            lowers.add(value);
            checkBalance(lowers, highers);
        } else {
            highers.add(value);
            checkBalance(highers, lowers);
        }
    }

    void remove(int value) {
        if (!lowers.isEmpty() && value <= lowers.peek() && lowers.remove(value)) {
            checkBalance(highers, lowers);
        } else if (!highers.isEmpty() && value >= highers.peek() && highers.remove(value)) {
            checkBalance(lowers, highers);
        }
    }

    float median() {
        if (lowers.isEmpty() && highers.isEmpty()) {
            throw new IllegalStateException();
        }

        if (lowers.size() > highers.size()) {
            return lowers.peek();
        }

        if (highers.size() > lowers.size()) {
            return highers.peek();
        }

        return (highers.peek() + lowers.peek()) / 2f;
    }

    public static void main(String[] args) {
        MedianTracker tracker = new MedianTracker();

        tracker.track(10);
        assert tracker.median() == 10;
        tracker.track(20);
        assert tracker.median() == 15;
        tracker.track(30);
        assert tracker.median() == 20;
        tracker.track(40);
        assert tracker.median() == 25;
        tracker.track(10);
        assert tracker.median() == 20;
        tracker.remove(10);
        assert tracker.median() == 25;
    }
}