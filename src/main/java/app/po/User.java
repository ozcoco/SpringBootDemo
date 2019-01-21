package app.po;

public class User {

    private int userId;

    private String name;

    private int age;

    private int gender;

    private String address;


    public User() {
    }

    public User(int userId, String name, int age, int gender, String address) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public static User newInstance() {

        return new User();

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
