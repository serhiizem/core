package junit5app.airport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("Duplicates")
public class AirportTest {

    @Nested
    class EconomyFlightTest {

        private Flight economFlight;

        @BeforeEach
        void setUp() {
            economFlight = new EconomyFlight();
        }

        @Test
        public void shouldNotBeAbleToRemoveVipPassengerFromEconomFlight() {
            Passenger johnVip = new Passenger("John", TRUE);
            economFlight.addPassenger(johnVip);

            assertEquals(economFlight.getPassengerList().size(), 1);

            economFlight.removePassenger(johnVip);

            assertEquals(economFlight.getPassengerList().size(), 1);
        }

        @Test
        public void shouldBeAbleToRemoveNonVipPassengerFromEconomFlight() {
            Passenger johnEconom = new Passenger("John", FALSE);
            economFlight.addPassenger(johnEconom);
            assertEquals(economFlight.getPassengerList().size(), 1);

            economFlight.removePassenger(johnEconom);

            assertEquals(economFlight.getPassengerList().size(), 0);
        }

        @Test
        public void passengerNameShouldNotBeChangedAfterBeingAddedToFlight() {
            String initialName = "John";
            Passenger john = new Passenger(initialName, FALSE);
            economFlight.addPassenger(john);

            Passenger retrievedPassenger = economFlight.getPassengerList().get(0);

            assertEquals(retrievedPassenger.getName(), initialName);
        }
    }

    @Nested
    class BusinessFlightTest {

        private Flight businessFlight;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight();
        }

        @Test
        public void shouldNotBeAbleToRemoveVipPassengerFromBusinessFlight() {
            Passenger johnVip = new Passenger("John", TRUE);
            businessFlight.addPassenger(johnVip);
            assertEquals(businessFlight.getPassengerList().size(), 1);

            businessFlight.removePassenger(johnVip);

            assertEquals(businessFlight.getPassengerList().size(), 1);
        }

        @Test
        public void shouldNotBeAbleToAddNotVipPassengerToBusinessFlight() {
            Passenger johnEconom = new Passenger("John", FALSE);

            businessFlight.addPassenger(johnEconom);

            assertEquals(businessFlight.getPassengerList().size(), 0);
        }
    }
}
