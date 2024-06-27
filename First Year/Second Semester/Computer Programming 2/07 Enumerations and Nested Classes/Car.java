public class Car {
    
    private int year;
    private Model model;
    private Color color;
    
    public Car(int yr, Model model, Color color) {
        this.year = yr;
        this.model = model;
        this.color = color;
    }
    
    public int getYear() {
        return year;
    }
    
    public Model getModel() {
        return model;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void display() {
        System.out.println("Car year: " + year);
        System.out.println("Car model: " + model);
        System.out.println("Car color: " + color);
    }
}