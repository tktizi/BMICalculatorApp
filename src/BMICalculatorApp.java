public class BMICalculatorApp {
    public static void main(String[] args) {
        // --- Перевірка основного класу BMI ---
        HumanBMI person = new HumanBMI(80, 1.52);
        System.out.println("BMI: " + String.format("%.2f", person.getBMI()));
        System.out.println("Status: " + person.getResult());

        // --- Тести для класу Triangle ---
        System.out.println("\n=== TESTS FOR TRIANGLE ===");
        Triangle t = new Triangle(3, 4, 5);

        // 1. Периметр
        System.out.println("Perimeter test: " + t.getPerimeter());

        // 2. Площа
        System.out.println("Area test: " + String.format("%.2f", t.getArea()));

        // 3. Перевірка типу
        System.out.println("Type test: " + t.getType());

        // 4. Перевірка чи прямокутний
        System.out.println("Is right triangle test: " + t.isRightTriangle());

        // 5. Масштабування
        t.scale(2);
        System.out.println("Scaled perimeter test: " + t.getPerimeter());
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

// --- Додатковий клас-фігура ---
class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (!isValid(a, b, c))
            throw new IllegalArgumentException("Triangle sides are invalid");
        this.a = a; this.b = b; this.c = c;
    }

    /** 1️⃣ Перевірка валідності трикутника */
    private boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /** 2️⃣ Обчислення периметра */
    public double getPerimeter() {
        return a + b + c;
    }

    /** 3️⃣ Обчислення площі (формула Герона) */
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /** 4️⃣ Визначення типу трикутника */
    public String getType() {
        if (a == b && b == c) return "Equilateral";
        else if (a == b || a == c || b == c) return "Isosceles";
        else return "Scalene";
    }

    /** 5️⃣ Перевірка, чи прямокутний */
    public boolean isRightTriangle() {
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        return Math.abs(Math.pow(sides[2], 2) - (Math.pow(sides[0], 2) + Math.pow(sides[1], 2))) < 1e-6;
    }

    /** 6️⃣ Масштабування (зміна розмірів) */
    public void scale(double factor) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive");
        a *= factor;
        b *= factor;
        c *= factor;
    }
}
