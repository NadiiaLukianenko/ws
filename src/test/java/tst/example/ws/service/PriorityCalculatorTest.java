package tst.example.ws.service;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PriorityCalculatorTest {

    @DataProvider(name = "dataProvider")
    public Object[][] readData() {
        List<Object[]> data = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("/home/hp/IdeaProjects/ws/src/main/resources/priorities.csv"))){
            br.readLine();

            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(new Object[]{
                        Double.parseDouble(values[0]),
                        Integer.parseInt(values[1]),
                        Long.parseLong(values[2]),
                        Double.parseDouble(values[3])});
            }
        } catch(IOException ex){

        }
        return data.toArray(new Object[0][0]);
    }

    @Test(dataProvider = "dataProvider")
    public void calculatorTest(double categoryPriority, int regionPriority, long receivedTime, double expectedPriority) {
        PriorityCalculator pc = new PriorityCalculator();
        double result = pc.calculate(categoryPriority,regionPriority,receivedTime);
        assertThat(result, equalTo(expectedPriority));
    }
}