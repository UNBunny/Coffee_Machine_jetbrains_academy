package machine;

public class CoffeeMachine {
    public static void main(String[] args) {
        Work work = new Work(400, 540, 120, 9, 550);
        work.execute();
    }
}