package core.patterns.structural;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LdapEmployeeAdapter implements Employee {

    private EmployeeLDAP instance;

    @Override
    public String getId() {
        return instance.getCn();
    }

    @Override
    public String getFirstName() {
        return instance.getGivenName();
    }

    @Override
    public String getLastName() {
        return instance.getDisplayName();
    }

    @Override
    public String getEmail() {
        return instance.getMail();
    }
}
