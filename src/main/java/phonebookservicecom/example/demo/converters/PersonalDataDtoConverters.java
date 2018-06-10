package phonebookservicecom.example.demo.converters;

import phonebookservicecom.example.demo.dto.PersonalDataDto;
import phonebookservicecom.example.demo.entity.PersonalData;

public interface PersonalDataDtoConverters {

    PersonalDataDto convert(PersonalData personalData);

    PersonalData convertDto(PersonalDataDto personalDataDto);
}
