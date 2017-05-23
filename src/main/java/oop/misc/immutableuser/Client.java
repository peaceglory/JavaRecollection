package oop.misc.immutableuser;

/**
 * Created by mman on 23.05.17.
 */
public class Client {

    public static void main(String[] args) {
        ImmutableUser user =
                new ImmutableUser.UserBuilder("shekhar", "password")
                        .firstName("shekhar")
                        .lastName("gulati")
                        .email("shekhargulati84@gmail.com")
                        .build();

        System.out.println(user);
    }
}
