import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DataList {
    private ArrayList<DataPoint> pointArrayList = new ArrayList<>();

    public DataList() {
    }

    public static DataPoint parseDWDLine(String line) {
        String[] strings = line.split(";");
        String date = strings[1];
        return new DataPoint(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(4, 6)),
                Integer.parseInt(date.substring(6, 8)),
                Double.parseDouble(strings[16]),
                Double.parseDouble(strings[15]),
                Double.parseDouble(strings[14]));
    }

    public void addDataPoint(DataPoint p) {
        pointArrayList.add(p);
    }

    public void addDataPointsFromFile(String filename) {
        try {
            BufferedReader r = new BufferedReader(new FileReader(new File(filename)));
            if (r.ready()) {
                r.readLine();
            }
            while (r.ready()) {
                addDataPoint(parseDWDLine(r.readLine()));
            }
            r.close();
        } catch (Exception e) {
            System.out.println("IO Exception");;
        }
    }

    public int getNumPoints() {
        return pointArrayList.size();
    }

    public DataList filterByYear(int year) {
        DataList dataList = new DataList();
        for (int i = 0; i < pointArrayList.size(); i++) {
            if (pointArrayList.get(i).getYear() == year){
                dataList.addDataPoint(pointArrayList.get(i));
            }
        }
        return dataList;
    }


    public double[] getMinTemps(){
        double[] res = new double[getNumPoints()];
        for (int i = 0; i < pointArrayList.size(); i++) {
            res[i] = pointArrayList.get(i).getMinTemp();
        }
        return res;
    }

    public double[] getMeanTemps(){
        double[] res = new double[getNumPoints()];
        for (int i = 0; i < pointArrayList.size(); i++) {
            res[i] = pointArrayList.get(i).getMeanTemp();
        }
        return res;
    }

    public double[] getMaxTemps(){
        double[] res = new double[getNumPoints()];
        for (int i = 0; i < pointArrayList.size(); i++) {
            res[i] = pointArrayList.get(i).getMaxTemp();
        }
        return res;
    }
}