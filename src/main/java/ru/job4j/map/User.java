package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

//    @Override
//    public String toString() {
//        return "User{"
//                + "name='" + name + '\''
//                + ", children=" + children
//                + ", birthday=" + birthday
//                + '}';
//    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>(16);
        Calendar birthday = Calendar.getInstance();
        User firstUser = new User("AAA", 1, birthday);
        User secondUser = new User("AAA", 1, birthday);
        int firstHashcode = firstUser.hashCode();
        int secondHashcode = secondUser.hashCode();
        int firstHash = firstHashcode ^ (firstHashcode >>> 16);
        int secondHash = secondHashcode ^ (secondHashcode >>> 16);
        int firstBucket = firstHash & 15;
        int secondBucket = secondHash & 15;
        map.put(firstUser, new Object());
        map.put(secondUser, new Object());
//        for (Map.Entry<User, Object> entry : map.entrySet()) {
//            System.out.println(entry);
//        }
        System.out.printf("u1 - хэшкод: %s, хэш: %s, бакет: %s",
                firstHashcode, firstHash, firstBucket);
        System.out.printf("u2 - хэшкод: %s, хэш: %s, бакет: %s",
                secondHashcode, secondHash, secondBucket);

    }
}
