public class DataPoint {
    private int year;
    private int month;
    private int day;
    private double minTemp;
    private double maxTemp;
    private double meanTemp;

    public DataPoint(int year, int month, int day, double minTemp, double maxTemp, double meanTemp) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.meanTemp = meanTemp;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMeanTemp() {
        return meanTemp;
    }

    @Override
    public String toString() {
        return minTemp + " - " + meanTemp + " - " + maxTemp + " on " + day + "." + month + "." + year;
    }
}
