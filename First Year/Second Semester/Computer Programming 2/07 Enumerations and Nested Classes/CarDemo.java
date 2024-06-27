public class CarDemo {
    public static void main(String[] args) {
        Car car1 = new Car(2018, Model.SUV, Color.RED);
        Car car2 = new Car(2015, Model.HATCHBACK, Color.WHITE);
        
        Car[] cars = {car1, car2};
        for (int i = 0; i<cars.length; i++) {
            System.out.println("Car " + (i + 1));
            cars[i].display();
            System.out.println();
        }
    }
}