package tst.example.ws.service;

import org.springframework.stereotype.Service;

@Service
public class PriorityCalculator {

    public double calculate(double categoryPriority, int regionPriority, long receivedTime) {
        return 2 * categoryPriority + regionPriority + receivedTime/1000.0;
    }
}
