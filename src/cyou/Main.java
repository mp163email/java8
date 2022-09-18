package cyou;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        cyou.User user = new cyou.User();
        user.setName("aaaaaaa");
        Optional<User> optional = Optional.ofNullable(user);
        optional.ifPresent(u -> System.out.println(u.getName()));

        //如果不为空就打印，如果为空就打印null
        User user1 = null;
        Optional.ofNullable(user1).ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("null"));

        Map<String, List<String>> mapList = new HashMap<>();
        List<String> list = mapList.computeIfAbsent("abc", x -> new ArrayList<>());//如果不存在就创建一个，并且放进去
        list.add("list-abc");
        mapList.get("abc").stream().forEach(x -> System.out.println(x));
    }
}
