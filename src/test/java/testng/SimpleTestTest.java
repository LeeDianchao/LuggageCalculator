package testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import calculation.Calculation;
import data.Luggage;
import data.Person;

public class SimpleTestTest {
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
        System.out.println("case" + id);
        System.out.println("����:" + flighttype);
        System.out.println("������λ:" + seattype);
        System.out.println("�ر�˿�:" + special);
        System.out.println("���ò�Ʊ��:" + eairfare);
        System.out.println("�����Ƿ��漰����:" + isusa);
        System.out.println("�������:" + no);
        System.out.println("����(KG):" + weight);
        System.out.println("��(cm):" + length);
        System.out.println("��(cm):" + width);
        System.out.println("��(cm):" + height);
        System.out.println("Ԥ��ֵ:" + id);
        System.out.println("------------------------------------");

        Person person = new Person(flighttype,seattype,special,eairfare,isusa);
        Calculation cal = new Calculation(person);
        float actualresult = cal.caculate(new Luggage(no,weight,length,width,height));	
        Assert.assertEquals(actualresult, expectresult, "Not equals: ");
    }
}
