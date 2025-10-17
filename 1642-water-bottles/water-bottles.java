public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        int empties = numBottles;
        while (empties >= numExchange) {
            int newBottles = empties / numExchange;
            sum += newBottles;
            empties = empties % numExchange + newBottles;
        }
        return sum;
    }
}