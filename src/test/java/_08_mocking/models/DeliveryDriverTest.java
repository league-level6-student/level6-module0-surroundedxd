package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import _07_intro_to_mocking.models.Engine;
import _07_intro_to_mocking.models.GasTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;

    @Mock
    Car car;

    @Mock
    CellPhone cellPhone;

    @Mock
    Engine engine;

    @Mock
    GasTank gasTank;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        deliveryDriver = new DeliveryDriver("Driver", car, cellPhone);
    }

    @Test
    void itShouldWasteTime() {
        when(cellPhone.browseCatMemes()).thenReturn(true);
        //given
        boolean expectedResult = true;

        //when
        boolean wastedTime = deliveryDriver.wasteTime();

        //then
        assertEquals(expectedResult, wastedTime);
    }

    @Test
    void itShouldRefuel() {
        when(car.fillTank(12)).thenReturn(true);

        //given
        boolean expectedResult = true;
        int octaneGrade = 12;

        //when
        boolean didRefuel = deliveryDriver.refuel(octaneGrade);

        //then
        assertEquals(didRefuel, expectedResult);
    }

    @Test
    void itShouldContactCustomer() {
        when(cellPhone.call("696-969-6969")).thenReturn(true);
        //given
        boolean expectedResult = true;
        String phoneNumber = "696-969-6969";

        //when
        boolean contactedCustomer = deliveryDriver.contactCustomer(phoneNumber);

        //then
        assertEquals(contactedCustomer, expectedResult);
    }

}