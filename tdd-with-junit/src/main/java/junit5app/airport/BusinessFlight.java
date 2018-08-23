package junit5app.airport;

@SuppressWarnings("SimplifiableIfStatement")
public class BusinessFlight extends Flight {

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVip()) {
            return passengerList.add(passenger);
        } else {
            return false;
        }
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }
}
