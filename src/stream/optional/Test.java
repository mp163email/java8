package stream.optional;

import java.util.Optional;

public class Test {

    public static void main(String[] args) {
        Address address = new Address();
        User user = new User();
        user.setName("aaaa");
        user.setPhone("1234");
       // user.setAddress(address);

       // System.out.println(user.getAddress().getCity());

        String sss = Optional.ofNullable(user).map(u -> u.getAddress()).map(a -> a.getCity()).orElse("cccc");
        String sss2 = Optional.ofNullable(user).map(u -> u.getAddress()).map(a -> a.getCity()).orElseGet(Test::getDefault);
        String sss1 = Optional.ofNullable(user)
                .map(u-> u.getAddress())
                .map(a->a.getCity())
                .orElseThrow(() -> new IllegalArgumentException());
        System.out.println(sss1);

    }

    public static String getDefault() {
        return "SSSSSSSSSSXXXXXXX";
    }
}
