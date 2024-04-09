import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class TemperatureUtilities {
    public static double[] getDifferenceOfTemperatures(double[] temps1, double[] temps2){
        double[] res = new double[temps1.length];
        for (int i = 0; i < temps1.length; i++) {
            res[i] = temps1[i] - temps2[i];
        }
        return res;
    }

    public static double getMeanTemperature(double[] temps){
        int sum = 0;
        for (int i = 0; i < temps.length; i++) {
            sum += temps[i];
        }
        return  (double) sum / temps.length;
    }

    public static String[] showDifferenceOfTemperatures(double[] temps1, double[] temps2, int year1, int year2){
        String[] res = new String[3];
        res[0] = "Year " + year1 + " mean temperature: " + getMeanTemperature(temps1);
        res[1] = "Year " + year2 + " mean temperature: " + getMeanTemperature(temps2);
        res[2] = "Mean of temperature difference: " + getMeanTemperature(getDifferenceOfTemperatures(temps2,temps1));
        return res;
    }

    public static void plotTemperatures(double[] temps1, double[] temps2, int year1, int year2, boolean showDifferences, String outfile){
        XYChart chart = new XYChart(800, 300);
        chart.setTitle(outfile.split("\\.")[0]);
        chart.setXAxisTitle("Day");
        chart.setYAxisTitle("Temp");

        chart.addSeries("Year "+year1, temps1).setMarker(SeriesMarkers.NONE);
        chart.addSeries("Year "+year2, temps2).setMarker(SeriesMarkers.NONE);
        if (showDifferences)
            chart.addSeries("Diff", getDifferenceOfTemperatures(temps1,temps2)).setMarker(SeriesMarkers.NONE);
        try {
            BitmapEncoder.saveBitmap(chart, outfile, BitmapFormat.PNG);
        } catch(Exception e) {
            System.out.println("IO Exception");
        }
    }
}