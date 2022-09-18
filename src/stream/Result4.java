package stream;

import org.junit.Test;

import java.util.Optional;

public class Result4 {

    @Test
    public void ofNullable () {
        String string = null;
        String string2 = Optional.ofNullable(string).get();
        System.out.println(string2);
    }
}
