package data;

import calculation.Calculation;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class UseCase {
    private Person person;
    private Calculation cal;

    public Object[][] UseCase(String path) {
        in_out io = new in_out();
        if (path == "") {
            return new Object[][]{
                    {1, 0, 0, 0, 1000, 0, 1, 40, 40, 40, 40, 0},
                    {2, 0, 0, 0, 1000, 0, 1, 50, 40, 40, 40, 150},
                    {3, 0, 0, 0, 1000, 0, 1, 40, 40, 100, 40, -1},
                    {4, 0, 1, 0, 1000, 0, 1, 40, 40, 40, 40, 150},
                    {5, 1, 0, 0, 1000, 1, 1, 45, 40, 40, 40, 3000},
                    {6, 1, 0, 0, 1000, 0, 1, 45, 40, 40, 40, -1},
                    {7, 1, 0, 0, 1000, 1, 1, 32, 40, 40, 100, 1000},
                    {8, 1, 0, 0, 1000, 1, 1, 32, 40, 100, 200, -1},
                    {9, 1, 4, 0, 1000, 1, 1, 10, 30, 35, 40, 0},
                    {10, 1, 4, 0, 1000, 1, 1, 10, 40, 40, 40, -2},
                    {11, 1, 4, 0, 1000, 1, 1, 11, 30, 35, 40, -2}
            };
        } else {
            List<String[]> allData = io.readCSV(path);
            Object[][] data = new Object[allData.size()][12];
            for (int i = 0; i < allData.size(); i++) {
                String item[] = allData.get(i);
                for (int j = 0; j < 12; j++) {
                    if (j == 0 || j == 1 || j == 2 || j == 3 || j == 5 || j == 6)
                        data[i][j] = Integer.parseInt(item[j]);
                    else
                        data[i][j] = Float.parseFloat(item[j]);
                }
            }
            return data;
        }
    }

    public void testUseCase(int id, int flighttype, int seattype, int special, float eairfare, int isusa, int no, float weight, float length, float width, float height, float expectresult) {

        in_out io = new in_out();
        File fileid = new File("./iddata.txt");//是否是新的用例
        String sid = "";
        File file = new File("./specialdata.txt");//保存是否使用特殊行李额
        String s = "";
        try {
            sid = io.readTxtFile(fileid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id != Integer.parseInt(sid)) {
            System.out.println("******************************");
            System.out.println("case:" + id);
            this.person = new Person(flighttype, seattype, special, eairfare, isusa);
            this.cal = new Calculation(this.person);
            try {
                io.writeTxtFile(Integer.toString(id), fileid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                io.writeTxtFile(Integer.toString(0), file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Navigation area:" + flighttype);
            System.out.println("Cabin or seat:" + seattype);
            System.out.println("Special passenger:" + special);
            System.out.println("Economy fare:" + eairfare);
            System.out.println("Contain USA:" + isusa);
        } else {
            this.person = new Person(flighttype, seattype, special, eairfare, isusa);
            this.cal = new Calculation(this.person);
            try {
                s = io.readTxtFile(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cal.setisusespecial(Integer.parseInt(s));
        }

        float actualresult = this.cal.caculate(new Luggage(no, weight, length, width, height));

        try {
            //System.out.println(this.cal.getisusespecial());
            io.writeTxtFile(Integer.toString(this.cal.getisusespecial()), file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(actualresult, expectresult, "Not equals: ");

        System.out.println("Baggage number:" + no);
        System.out.println("Weight(KG):" + weight);
        System.out.println("Length(cm):" + length);
        System.out.println("Wide(cm):" + width);
        System.out.println("Height(cm):" + height);
        System.out.println("Expect value:" + expectresult);
        System.out.println("----------------");
    }
}
