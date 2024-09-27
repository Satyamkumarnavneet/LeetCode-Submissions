class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] o : overlaps) {
            if (o[0] < end && o[1] > start) {
                return false;
            }
        }
        for (int[] b : bookings) {
            if (b[0] < end && b[1] > start) {
                overlaps.add(new int[]{Math.max(start, b[0]), Math.min(end, b[1])});
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }
}
