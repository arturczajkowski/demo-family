package phonebookservicecom.example.demo.converters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import phonebookservicecom.example.demo.dto.ChildDto;
import phonebookservicecom.example.demo.entity.Child;
import phonebookservicecom.example.demo.entity.Sex;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ChildDtoConvertersTest {
    @Autowired
    private ChildDtoConverter childDtoConverter;

    @Test
    public void shouldConvertFatherDtoProperly() {

        Child  child = new Child(2,"Ania", "Czajkowski","11247659481","11-01-2011", Sex.GIRL);
        ChildDto childDto = childDtoConverter.convert(child);
        Assert.assertEquals(childDto.getLastName(), "Czajkowski");
        Assert.assertEquals(childDto.getDateOfBirth(), "11-01-2011");
        Assert.assertEquals(childDto.getType(), "dziewczynka");
    }
}
