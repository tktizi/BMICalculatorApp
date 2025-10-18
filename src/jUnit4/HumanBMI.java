package jUnit4;

public class HumanBMI {
    private double weight; // вага в кг
    private double height; // зріст у метрах

    private static final double UNDERWEIGHT_THRESHOLD = 18.5;
    private static final double NORMAL_THRESHOLD = 25.0;
    private static final double OVERWEIGHT_THRESHOLD = 30.0;

    public HumanBMI(double weight, double height) {
        if (height <= 0) throw new IllegalArgumentException("Height must be greater than 0");
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() { return weight; }

    public void setWeight(double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
        this.weight = weight;
    }

    public double getHeight() { return height; }

    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Height must be greater than 0");
        this.height = height;
    }

    /** Розрахунок індексу маси тіла */
    public double getBMI() {
        return weight / (height * height);
    }

    /** Визначення категорії BMI */
    public String getResult() {
        double bmi = getBMI();
        if (bmi < UNDERWEIGHT_THRESHOLD) return "Underweight";
        else if (bmi < NORMAL_THRESHOLD) return "Normal";
        else if (bmi < OVERWEIGHT_THRESHOLD) return "Overweight";
        else return "Obesity";
    }
}

