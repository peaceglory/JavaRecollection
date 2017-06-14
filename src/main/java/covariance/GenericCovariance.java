package covariance;

/**
 * Created by developer on 6/14/17.
 */
public class GenericCovariance {

    static class Being {}
    static class Person extends Being {}

    static class Mob<T extends Being> {
        T someone;

        void lynch(T someone) {
            this.someone = someone;
        }

        T produceLeader() {
            return someone;
        }
    }

    public static void main(String[] args) {
        Mob<Being> beingsMob = new Mob<>();
        Mob<Person> personMob = new Mob<>();

        // Generic types are invariant, meaning they are not compatible with each other, this won't compile.
//        beingsMob = personMob;
//        personMob = beingsMob;

        // covariance achieved via wildcard.
        Mob<?> mob1;
        Mob<?> mob2;
        mob1 = new Mob<Being>();
        mob2 = new Mob<Person>();

        mob1 = mob2;

        // Wildcard is not a type so this fails
//        mob1.lynch(new Person());

        // now it works:
        Mob<Person> mob3 = new Mob<>();
        mob3.lynch(new Person());

        // wildcard is only compatible to Object, so:
//        Person p = mob1.produceLeader(); // fails
        Object o = mob1.produceLeader(); // OK
    }
}
