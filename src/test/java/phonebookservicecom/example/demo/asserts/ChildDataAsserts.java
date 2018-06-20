package phonebookservicecom.example.demo.asserts;

import org.junit.Assert;
import phonebookservicecom.example.demo.entity.Child;



public class ChildDataAsserts {

    private Child child;

    public ChildDataAsserts(Child child) {
        this.child = child;
    }

    public ChildDataAsserts hasLastName(String lastName) {
        Assert.assertEquals(child.getLastName(), lastName);
        return this;
    }
}
