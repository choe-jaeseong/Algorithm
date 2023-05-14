package 해시.기본코드;

import java.util.HashSet;

public class practice2 {
    private static class Coord {
        public final int x;
        public final int y;

        private Coord(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (x + "," + y).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Coord)) return false;
            Coord o = (Coord) obj;
            return x == o.x && y == o.y;
        }
    }

    public static void main(String[] args) {
        HashSet<Coord> coordSet = new HashSet<>();

        Coord coord1 = new Coord(1, 2);
        coordSet.add(coord1);
        Coord coord2 = new Coord(1, 2);

        System.out.println(coordSet.contains(coord2));
    }
}
