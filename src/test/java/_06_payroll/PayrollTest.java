package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
        int a = 69;
        int b = 420;

        //when
        double result = payroll.calculatePaycheck(a, b);

        //then
        assertEquals(28980, result);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
        int a = 69420;

        //when
        double result = payroll.calculateMileageReimbursement(a);

        //then
        assertEquals(39916.5d, result);
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
        String name = "Joe";
        double wage = 69d;

        //when
        String result = payroll.createOfferLetter(name, wage);

        //then
        assertEquals("Hello Joe, We are pleased to offer you an hourly wage of 69.0", result);
    }

}