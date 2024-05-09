package dto;

public class UserWith {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserWith() {
    }
//    UserWith userWith = new UserWith();
//    userWith.withUsername("Jane").withPassword("ksdjfh");

    public String getUsername() {
        return username;
    }

    public UserWith withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserWith withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserWith withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserWith withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
