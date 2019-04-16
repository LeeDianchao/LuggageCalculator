package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.*;

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
        UseCase useCase = new UseCase();
        return useCase.UseCase("test.csv");
    }
    
    @Test(dataProvider="usecase")
    public void test(int id, int flighttype, int seattype, int special, float eairfare, int isusa, int no, float weight, float length, float width, float height, float expectresult){
        UseCase useCase = new UseCase();
        useCase.testUseCase(id, flighttype, seattype, special, eairfare, isusa, no, weight, length, width, height, expectresult);

    }
}
