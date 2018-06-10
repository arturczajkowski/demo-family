package phonebookservicecom.example.demo.entity;

import javax.persistence.*;

@Entity
public class  PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumer;

    @Enumerated
    private TelephonNumberType type;

    public PersonalData(){

    }

    public PersonalData(Integer id,String firstName, String lastName, String phoneNumber, TelephonNumberType type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumer = phoneNumber;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TelephonNumberType getType() {
        return type;
    }

    public void setType(TelephonNumberType type) {
        this.type = type;
    }

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }
}
