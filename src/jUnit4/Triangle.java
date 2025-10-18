package jUnit4;

public class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        if (!isValid(a, b, c))
            throw new IllegalArgumentException("Triangle sides are invalid");
        this.a = a; this.b = b; this.c = c;
    }

    private boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    /** 1️⃣ Периметр */
    public double getPerimeter() {
        return a + b + c;
    }

    /** 2️⃣ Площа за формулою Герона */
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /** 3️⃣ Тип трикутника */
    public String getType() {
        if (a == b && b == c) return "Equilateral";
        else if (a == b || a == c || b == c) return "Isosceles";
        else return "Scalene";
    }

    /** 4️⃣ Перевірка прямого */
    public boolean isRightTriangle() {
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        return Math.abs(Math.pow(sides[2], 2) - (Math.pow(sides[0], 2) + Math.pow(sides[1], 2))) < 1e-6;
    }

    /** 5️⃣ Масштабування */
    public void scale(double factor) {
        if (factor <= 0) throw new IllegalArgumentException("Scale factor must be positive");
        a *= factor;
        b *= factor;
        c *= factor;
    }
}

