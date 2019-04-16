package testng;

import calculation.Calculation;
import data.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1 {
    @BeforeClass
    public void setUp() {
        System.out.println("*****TestNG*****");
        System.out.println("TestNG test case:");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("*****Test over*****");
    }

    @DataProvider(name="case")
    public Object[][] Case(){
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
    }

    @Test(dataProvider="case")
    public void test(int id, int flighttype, int seattype, int special, float eairfare, int isusa, int no, float weight, float length, float width, float height, float expectresult){
        UseCase useCase = new UseCase();
        useCase.testUseCase(id, flighttype, seattype, special, eairfare, isusa, no, weight, length, width, height, expectresult);
    }
}
