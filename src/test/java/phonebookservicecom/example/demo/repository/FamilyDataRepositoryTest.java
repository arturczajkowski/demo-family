package phonebookservicecom.example.demo.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import phonebookservicecom.example.demo.asserts.FatherDataAsserts;
import phonebookservicecom.example.demo.entity.Child;
import phonebookservicecom.example.demo.entity.Father;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyDataRepositoryTest {
//    @Autowired
//    private PersonalDataRepository personalDataRepository;

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private ChildRepository childRepository;

    @Test
    public void findChildAll() throws Exception {
        List<Child> childData = (List<Child>) childRepository.findAll();
        Assert.assertEquals(2, childData.size());
    }

    @Test
    public void findFatherAll() throws Exception {
        List<Father> fatherData = (List<Father>) fatherRepository.findAll();
        Assert.assertEquals(2, fatherData.size());
    }

    @Test
    public void findFatherByLastName() throws Exception {
        List<Father> personalData = fatherRepository.findByLastName("Czajkowski");
        Assert.assertEquals(1, personalData.size());
    }

    @Test
    public void findChildByLastName() throws Exception {
        List<Child> personalData = childRepository.findByLastName("Czajkowski");
        Assert.assertEquals(2, personalData.size());
    }

    @Test
    public void findByLastNane() throws Exception {
        List<Father> personalData = fatherRepository.findByLastName("Czajkowski");
        Assert.assertEquals(1, personalData.size());
    }

    @Test
    public void shouldSaveFather() {


        Father father = new Father(2, "Grzegorz", "Mrowiec", "4324231","14-12-1994");
        fatherRepository.save(father);
        Father fatherFromDatabase = fatherRepository.findOne(2);
        new FatherDataAsserts(fatherFromDatabase).hasLastName("Mrowiec");
    }

}