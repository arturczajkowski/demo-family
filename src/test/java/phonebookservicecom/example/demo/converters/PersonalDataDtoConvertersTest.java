package phonebookservicecom.example.demo.converters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import phonebookservicecom.example.demo.dto.PersonalDataDto;
import phonebookservicecom.example.demo.entity.PersonalData;
import phonebookservicecom.example.demo.entity.TelephonNumberType;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonalDataDtoConvertersTest {

    @Autowired
    private PersonalDataDtoConverters personalDataDtoConverters;

    @Test
    public void shouldConvertPersonalDataDtoProperly() {
        PersonalData personalData = new PersonalData(1, "Artur", "Czajkowski", "792905836", TelephonNumberType.HOMEPHONE);
        PersonalDataDto personalDataDto = personalDataDtoConverters.convert(personalData);
        Assert.assertEquals(personalDataDto.getLastName(), "Czajkowski");
        Assert.assertEquals(personalDataDto.getType(), "domowy");
    }
}

