package testng;

import data.in_out;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import calculation.Calculation;
import data.Luggage;
import data.Person;

import java.io.File;

public class SimpleTestTest {
    private Person person;
    private Calculation cal;
	@BeforeClass
    public void setUp() {
		System.out.println("*****TestNG*****");
		System.out.println("TestNG test case:");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("*****Test over*****");
    }
    
//  1�������������
//	2������
//	3��������λ
//	4���ر�˿�
//	5�����ò�Ʊ��
//	6�������Ƿ��漰����
//	7���������
//	8������
//	9����
//	10����
//	11����
//	12��Ԥ��ֵ
    @DataProvider(name="usecase")
    public Object[][] UseCase(){
        return new Object[][]{
                {1,0,0,0,1000,0,1,40,40,40,40,0},
                {2,0,0,0,1000,0,1,50,40,40,40,150},
                {3,0,0,0,1000,0,1,40,40,100,40,-1},
                {4,0,1,0,1000,0,1,40,40,40,40,150},
                {5,1,0,0,1000,1,1,45,40,40,40,3000},
                {6,1,0,0,1000,0,1,45,40,40,40,-1},
                {7,1,0,0,1000,1,1,32,40,40,100,1000},
                {8,1,0,0,1000,1,1,32,40,100,200,-1},
                {9,1,4,0,1000,1,1,10,30,35,40,0},
                {10,1,4,0,1000,1,1,10,40,40,40,-2},
                {11,1,4,0,1000,1,1,11,30,35,40,-2}
        };
    }
    
    @Test(dataProvider="usecase")
    public void verifyUser(int id, int flighttype, int seattype, int special, int eairfare, int isusa, int no, float weight, float length, float width, float height, float expectresult){
        System.out.println("case:" + id);
        System.out.println("Navigation area:" + flighttype);
        System.out.println("Cabin or seat:" + seattype);
        System.out.println("Special passenger:" + special);
        System.out.println("Economy fare:" + eairfare);
        System.out.println("Contain USA:" + isusa);
        System.out.println("Baggage number:" + no);
        System.out.println("Weight(KG):" + weight);
        System.out.println("Length(cm):" + length);
        System.out.println("Wide(cm):" + width);
        System.out.println("Height(cm):" + height);
        System.out.println("Expect value:" + id);
        System.out.println("------------------------------------");

        in_out io=new in_out();
        File fileid = new File("./iddata.txt");//�Ƿ����µ�����
        String sid="";
        File file = new File("./specialdata.txt");//�����Ƿ�ʹ�����������
        String s="";
        try {
            sid=io.readTxtFile(fileid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(id!=Integer.parseInt(sid))
        {
            this.person=new Person(flighttype,seattype,special,eairfare,isusa);
            this.cal=new Calculation(this.person);
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
        }
        else
        {
            this.person=new Person(flighttype,seattype,special,eairfare,isusa);
            this.cal=new Calculation(this.person);
            try {
                s=io.readTxtFile(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.cal.setisusespecial(Integer.parseInt(s));
        }

        float actualresult=this.cal.caculate(new Luggage(no,weight,length,width,height));

        try {
            //System.out.println(this.cal.getisusespecial());
            io.writeTxtFile(Integer.toString(this.cal.getisusespecial()), file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(actualresult, expectresult, "Not equals: ");
    }
}
