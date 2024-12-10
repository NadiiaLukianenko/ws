package tst.example.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tst.example.ws.model.Call;
import tst.example.ws.model.Category;

import java.time.ZoneOffset;

@Service
public class CallService {

    private final static double DEFAULT_CATEGORY_PRIORITY = 10.0;

    private PriorityCalculator calculator;

    @Autowired
    public CallService(PriorityCalculator calculator) {
        this.calculator = calculator;
    }

    public double getPriority(Call call) {
        double categoryPriority = call.getCategories().stream()
                .mapToInt(Category::getCategoryPriority).average().orElse(DEFAULT_CATEGORY_PRIORITY);
        int regionPriority = call.getLocation().getPriority();
        long receivedTime = call.getReceivedDateTime().toEpochSecond(ZoneOffset.UTC);
        return calculator.calculate(categoryPriority, regionPriority, receivedTime);
    }

}
