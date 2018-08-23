package junit5app.airport;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Flight {

    protected List<Passenger> passengerList = new ArrayList<>();

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
}
