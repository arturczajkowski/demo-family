package phonebookservicecom.example.demo.converters;

import phonebookservicecom.example.demo.dto.PersonalDataDto;
import phonebookservicecom.example.demo.entity.PersonalData;

public interface PersonalDataDtoConverters {

    public PersonalDataDto convert(PersonalData personalData);

    public PersonalData convertDto(PersonalDataDto personalDataDto);
}
