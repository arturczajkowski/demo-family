package phonebookservicecom.example.demo.converters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import phonebookservicecom.example.demo.dto.FatherDto;
import phonebookservicecom.example.demo.entity.Father;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FatherDtoConvertersTest {

    @Autowired
    private FatherDtoConverter fatherDtoConverter;

    @Test
    public void shouldConvertFatherDtoProperly() {

        Father father = new Father(1,"Artur","Czajkowski","93081502136","15-08-1993");
        FatherDto fatherDto = fatherDtoConverter.convert(father);
        Assert.assertEquals(fatherDto.getLastName(), "Czajkowski");
        Assert.assertEquals(fatherDto.getDateOfBirth(), "15-08-1993");
    }
}

