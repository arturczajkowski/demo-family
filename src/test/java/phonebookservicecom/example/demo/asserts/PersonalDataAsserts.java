package phonebookservicecom.example.demo.asserts;

import org.junit.Assert;
import phonebookservicecom.example.demo.entity.PersonalData;

public class PersonalDataAsserts {
    private PersonalData personalData;

    public PersonalDataAsserts(PersonalData personalData) {
        this.personalData = personalData;
    }

    public PersonalDataAsserts hasLastName(String lastName) {
        Assert.assertEquals(personalData.getLastName(), lastName);
        return this;
    }
}
