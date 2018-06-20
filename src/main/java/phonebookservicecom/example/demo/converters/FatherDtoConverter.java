package phonebookservicecom.example.demo.converters;


import phonebookservicecom.example.demo.dto.FatherDto;
import phonebookservicecom.example.demo.entity.Father;

public interface FatherDtoConverter {

    FatherDto convert(Father father);
    Father convertDto(FatherDto fatherDto);
}
