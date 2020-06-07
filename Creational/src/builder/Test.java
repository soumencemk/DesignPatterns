package builder;

/**
 * @author Soumen Karmakar
 * 07/06/2020
 */
public class Test {
    public static void main(String[] args) {
        User.UserBuilder userBuilder = new User.UserBuilder("Soumen", "Karmakar");
        User user1 = userBuilder
                .age(30)
                .address("Reading, UK")
                .build();
        User user2 = userBuilder
                .address("Reading, UK")
                .phone("+447404773202")
                .build();
        System.out.println(user1);
        System.out.println(user2);

    }
}
