package phonebookservicecom.example.demo.asserts;

import org.junit.Assert;
import phonebookservicecom.example.demo.entity.Father;


public class FatherDataAsserts {

    private Father father;

    public FatherDataAsserts(Father father) {
        this.father = father;
    }

    public FatherDataAsserts hasLastName(String lastName) {
        Assert.assertEquals(father.getLastName(), lastName);
        return this;
    }
}
