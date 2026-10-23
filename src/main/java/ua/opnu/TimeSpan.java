package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan() { this(0); }

    public TimeSpan(int minutes) {
        setTotalMinutes(minutes);
    }

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Invalid hours or minutes");
        }
        setTotalMinutes((long) hours * 60 + minutes);
    }

    public TimeSpan(TimeSpan span) {
        this(span.getHours(), span.getMinutes());
    }

    private void setTotalMinutes(long total) {
        if (total < 0 || total > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Time interval is out of range");
        }
        hours = (int) (total / 60);
        minutes = (int) (total % 60);
    }

    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Invalid time to add");
        }
        setTotalMinutes(totalLong() + (long) hours * 60 + minutes);
    }

    public void add(int minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Negative minutes");
        setTotalMinutes(totalLong() + minutes);
    }

    public void add(TimeSpan span) { add(span.getHours(), span.getMinutes()); }

    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Invalid time to subtract");
        }
        long result = totalLong() - ((long) hours * 60 + minutes);
        if (result >= 0) setTotalMinutes(result);
    }

    public void subtract(int minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Negative minutes");
        long result = totalLong() - minutes;
        if (result >= 0) setTotalMinutes(result);
    }

    public void subtract(TimeSpan span) { subtract(span.getHours(), span.getMinutes()); }

    private long totalLong() { return (long) hours * 60 + minutes; }

    public double getTotalHours() { return hours + minutes / 60.0; }
    public int getTotalMinutes() { return Math.toIntExact(totalLong()); }

    public void scale(int factor) {
        if (factor <= 0) throw new IllegalArgumentException("Factor must be positive");
        setTotalMinutes(totalLong() * factor);
    }

    @Override
    public String toString() { return hours + " год " + minutes + " хв"; }
}
