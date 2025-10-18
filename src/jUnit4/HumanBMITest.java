package jUnit4;

import org.junit.Test;
import static org.junit.Assert.*;

public class HumanBMITest {

    @Test
    public void testGetBMI_NormalValue() {
        HumanBMI person = new HumanBMI(70, 1.75);
        assertEquals(22.86, person.getBMI(), 0.01);
    }

    @Test
    public void testGetBMI_Overweight() {
        HumanBMI person = new HumanBMI(90, 1.70);
        assertEquals(31.14, person.getBMI(), 0.01);
    }

    @Test
    public void testGetResult_Normal() {
        HumanBMI person = new HumanBMI(68, 1.70);
        assertEquals("Normal", person.getResult());
    }

    @Test
    public void testGetResult_Obesity() {
        HumanBMI person = new HumanBMI(100, 1.65);
        assertEquals("Obesity", person.getResult());
    }

    @Test
    public void testSetWeight() {
        HumanBMI person = new HumanBMI(60, 1.60);
        person.setWeight(80);
        assertEquals(80, person.getWeight(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetWeight_Negative() {
        HumanBMI person = new HumanBMI(60, 1.60);
        person.setWeight(-5);
    }

    @Test
    public void testSetHeight() {
        HumanBMI person = new HumanBMI(60, 1.60);
        person.setHeight(1.70);
        assertEquals(1.70, person.getHeight(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHeight_Zero() {
        HumanBMI person = new HumanBMI(60, 1.60);
        person.setHeight(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidHeight() {
        new HumanBMI(70, -1.8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidWeight() {
        new HumanBMI(-10, 1.8);
    }
}
