package lambda;

/**
 * Auth: miaopeng
 * Date: 2018-11-30 11:38:51
 */
public interface EmployeeFilter<T> {
    boolean filter (T t);
}
