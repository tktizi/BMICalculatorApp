public class BMICalculatorApp {
    public static void main(String[] args) {
        // --- Тест для HumanBMI ---
        HumanBMI person = new HumanBMI(80, 1.52);
        System.out.println("BMI: " + String.format("%.2f", person.getBMI()));
        System.out.println("Status: " + person.getResult());

        // --- Тести для Triangle ---
        System.out.println("\n=== TESTS FOR TRIANGLE ===");
        Triangle t1 = new Triangle(3, 4, 5);
        Triangle t2 = new Triangle(6, 6, 6);

        // ------------------- TESTS -------------------
        // 1️⃣ getPerimeter()
        System.out.println("Perimeter test #1: " + t1.getPerimeter() + " (expected 12.0)");
        System.out.println("Perimeter test #2: " + t2.getPerimeter() + " (expected 18.0)");

        // 2️⃣ getArea()
        System.out.println("Area test #1: " + String.format("%.2f", t1.getArea()) + " (expected 6.00)");
        System.out.println("Area test #2: " + String.format("%.2f", t2.getArea()) + " (expected ~15.59)");

        // 3️⃣ getType()
        System.out.println("Type test #1: " + t1.getType() + " (expected Scalene)");
        System.out.println("Type test #2: " + t2.getType() + " (expected Equilateral)");

        // 4️⃣ isRightTriangle()
        System.out.println("Is right triangle test #1: " + t1.isRightTriangle() + " (expected true)");
        System.out.println("Is right triangle test #2: " + t2.isRightTriangle() + " (expected false)");

        // 5️⃣ scale()
        Triangle t3 = new Triangle(3, 4, 5);
        Triangle t4 = new Triangle(2, 2, 3);
        t3.scale(2);
        t4.scale(0.5);
        System.out.println("Scaled perimeter test #1: " + t3.getPerimeter() + " (expected 24.0)");
        System.out.println("Scaled perimeter test #2: " + String.format("%.2f", t4.getPerimeter()) + " (expected 3.50)");
    }
}

// --- Клас для розрахунку ІМТ ---
class HumanBMI {
    private double weight;
    private double height;

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
    public double getBMI() { return weight / (height * height); }

    /** Визначення категорії BMI */
    public String getResult() {
        double bmi = getBMI();
        if (bmi < UNDERWEIGHT_THRESHOLD) return "Underweight";
        else if (bmi < NORMAL_THRESHOLD) return "Normal";
        else if (bmi < OVERWEIGHT_THRESHOLD) return "Overweight";
        else return "Obesity";
    }
}

// --- Клас фігури: Трикутник ---
class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (!isValid(a, b, c))
            throw new IllegalArgumentException("Triangle sides are invalid");
        this.a = a; this.b = b; this.c = c;
    }

    /** Перевірка валідності трикутника */
    private boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /** 1️⃣ Обчислення периметра */
    public double getPerimeter() {
        return a + b + c;
    }

    /** 2️⃣ Обчислення площі (формула Герона) */
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /** 3️⃣ Визначення типу трикутника */
    public String getType() {
        if (a == b && b == c) return "Equilateral";
        else if (a == b || a == c || b == c) return "Isosceles";
        else return "Scalene";
    }

    /** 4️⃣ Перевірка, чи прямокутний */
    public boolean isRightTriangle() {
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        return Math.abs(Math.pow(sides[2], 2) - (Math.pow(sides[0], 2) + Math.pow(sides[1], 2))) < 1e-6;
    }

    /** 5️⃣ Масштабування (зміна розмірів) */
    public void scale(double factor) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive");
        a *= factor;
        b *= factor;
        c *= factor;
    }
}
