package phonebookservicecom.example.demo.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import phonebookservicecom.example.demo.asserts.PersonalDataAsserts;
import phonebookservicecom.example.demo.entity.PersonalData;
import phonebookservicecom.example.demo.entity.TelephonNumberType;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonalDataRepositoryTest {

    @Autowired
    private PersonalDataRepository personalDataRepository;

    @Test
    public void findAll() throws Exception {
        List<PersonalData> personalData = (List<PersonalData>) personalDataRepository.findAll();
        Assert.assertEquals(7, personalData.size());
    }

    @Test
    public void findByLastName() throws Exception {
        List<PersonalData> personalData = personalDataRepository.findByLastName("Czajkowski");
        Assert.assertEquals(2, personalData.size());
    }

    @Test
    public void findByPhoneNumer() throws Exception {
        List<PersonalData> personalData = personalDataRepository.findByPhoneNumer("792905836");
        Assert.assertEquals(1, personalData.size());
    }

    @Test
    public void shouldSaveProduct() {
        PersonalData personalData = new PersonalData(8, "Grzegorz", "Mrowiec", "4324231", TelephonNumberType.WORKPHONE);
        personalDataRepository.save(personalData);
        PersonalData productFromDatabase = personalDataRepository.findOne(8);
        new PersonalDataAsserts(productFromDatabase).hasLastName("Mrowiec");
    }

}