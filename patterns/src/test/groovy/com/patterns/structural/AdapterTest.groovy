package com.patterns.structural

import core.patterns.structural.Employee
import core.patterns.structural.EmployeeDB
import core.patterns.structural.EmployeeLDAP
import core.patterns.structural.LdapEmployeeAdapter
import spock.lang.Specification

class AdapterTest extends Specification {

    def "should adapt LDAP Employee (code of which is out of developer's control) to regular Employee"() {
        given:
        def resultingLastName = "Last Name2"
        def unassignableEmployee = new EmployeeLDAP("2,Name2," + resultingLastName + ",em_2@gmail.com")

        when:
        Employee employee = new LdapEmployeeAdapter(unassignableEmployee)

        then:
        employee.getLastName() == resultingLastName
    }

    def "Should be able to assign EmployeeDB (type which is under control of developer) to Employee type"() {
        given:
        def initialEmpId = "1"

        when:
        Employee employee = new EmployeeDB(initialEmpId, "Name1", "LastName1", "em_1@gmail.com")

        then:
        employee.getId() == initialEmpId
    }
}
