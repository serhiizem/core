package junit5app.airport;

@SuppressWarnings("SimplifiableIfStatement")
public class EconomyFlight extends Flight {

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengerList.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (!passenger.isVip()) {
            return passengerList.remove(passenger);
        }
        return false;
    }
}
