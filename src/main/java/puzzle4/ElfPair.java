package puzzle4;

public class ElfPair {

    public Interval interval1;
    public Interval interval2;

    /**
     * interval1 or interval2 completely envelops the other.
     * @return true if any complete overlap
     */
    public boolean isCompleteOverlap() {
        //is interval1 enveloped?
        if (interval1.a >= interval2.a) {
            if(interval1.b <= interval2.b)
                return true;
        }

        //is interval2 enveloped?
        if (interval2.a >= interval1.a) {
            return interval2.b <= interval1.b;
        }

        return false;
    }

    /**
     * interval1 or interval2 partly overlaps the other.
     * @return true if any complete overlap
     */
    public boolean isPartialOverlap() {
        if(isCompleteOverlap())
            return true;

        if(interval2.b >= interval1.a && interval2.a <= interval1.a)
            return true;

        return interval1.b >= interval2.a && interval1.a <= interval2.a;
    }

    /**
     * @param line such as "1-2,3-4"
     * @return -
     */
    public static ElfPair parse(String line) {
        ElfPair elfPair = new ElfPair();

        String[] tokens = line.split(",");

        String[] tokensPair1 = tokens[0].split("-");
        String[] tokensPair2 = tokens[1].split("-");

        elfPair.interval1 = new Interval(Integer.parseInt(tokensPair1[0]), Integer.parseInt(tokensPair1[1]));
        elfPair.interval2 = new Interval(Integer.parseInt(tokensPair2[0]), Integer.parseInt(tokensPair2[1]));

        return elfPair;
    }

    //interval from a (inclusive) to b (inclusive)
    public static class Interval {
        public int a;
        public int b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}