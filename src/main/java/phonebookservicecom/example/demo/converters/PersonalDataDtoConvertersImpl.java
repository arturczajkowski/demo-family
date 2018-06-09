package phonebookservicecom.example.demo.converters;


import org.springframework.stereotype.Component;
import phonebookservicecom.example.demo.dto.PersonalDataDto;
import phonebookservicecom.example.demo.entity.PersonalData;
import phonebookservicecom.example.demo.entity.TelephonNumberType;

@Component
public class PersonalDataDtoConvertersImpl implements PersonalDataDtoConverters {
    @Override
    public PersonalDataDto convert(PersonalData personalData) {
        PersonalDataDto personalDataDto = new PersonalDataDto();
        personalDataDto.setId(personalData.getId());
        personalDataDto.setFirstName(personalData.getFirstName());
        personalDataDto.setLastName(personalData.getLastName());
        personalDataDto.setPhoneNumber(personalData.getPhoneNumer());
        personalDataDto.setType(personalData.getType().getValue());
        return personalDataDto;
    }

    @Override
    public PersonalData convertDto(PersonalDataDto personalDataDto) {
        return new PersonalData(personalDataDto.getId(), personalDataDto.getFirstName(), personalDataDto.getLastName(),
                personalDataDto.getPhoneNumber(),TelephonNumberType.valueOf(personalDataDto.getType()));
    }
}
