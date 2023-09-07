package bookjava;

public class Member {

    private int id;
    private String name;
    private String cin;
    private String phoneNumber;

    public Member(int id, String name, String cin, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.cin = cin;
        this.phoneNumber = phoneNumber;
    }

    void setID(int ID) {
        id = ID;
    }

    void setName(String Name) {
        name = Name;
    }

    void setCIN(String CIN) {
        cin = CIN;
    }

    void setPhoneNumber(String PhoneNumber) {
        phoneNumber = PhoneNumber;
    }


    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCIN() {
        return cin;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
