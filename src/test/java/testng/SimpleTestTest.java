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
    
//  1：测试用例序号
//	2：航区
//	3：舱室座位
//	4：特别乘客
//	5：经济舱票价
//	6：航线是否涉及美国
//	7：行李序号
//	8：重量
//	9：长
//	10：宽
//	11：高
//	12：预测值
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
