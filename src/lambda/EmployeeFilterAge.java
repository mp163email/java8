package lambda;

/**
 * Auth: miaopeng
 * Date: 2018-11-30 11:39:41
 */
public class EmployeeFilterAge implements EmployeeFilter<Employee> {
    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() > 1;
    }
}
