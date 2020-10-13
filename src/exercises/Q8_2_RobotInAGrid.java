package exercises;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;

public class Q8_2_RobotInAGrid {
    private static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i &&
                    j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    private static LinkedList<Point> findPath(int[][] grid) {
        return findPath(
                grid,
                new Point(0, 0),
                new Point(grid.length - 1, grid[0].length - 1),
                new HashSet<>());
    }

    private static LinkedList<Point> findPath(int[][] grid,
                                              Point point,
                                              Point target,
                                              HashSet<Point> deadEnds) {
        if (point.i > target.i
                || point.j > target.j
                || grid[point.i][point.j] == 1
                || deadEnds.contains(point)) {
            return null;
        }


        if (target.equals(point)) {
            LinkedList<Point> path = new LinkedList<>();
            path.add(point);
            return path;
        }

        LinkedList<Point> right = findPath(grid, new Point(point.i, point.j + 1), target, deadEnds);

        if (right != null) {
            right.addFirst(point);
            return right;
        }

        LinkedList<Point> down = findPath(grid, new Point(point.i + 1, point.j), target, deadEnds);

        if (down != null) {
            down.addFirst(point);
            return down;
        }

        deadEnds.add(point);

        return null;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0}
        };

        for (Point point : findPath(grid)) {
            System.out.println(point.i + ", " + point.j);
        }
    }
}
