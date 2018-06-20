package phonebookservicecom.example.demo.converters;


import phonebookservicecom.example.demo.dto.ChildDto;
import phonebookservicecom.example.demo.entity.Child;

public interface ChildDtoConverter {

    ChildDto convert(Child child);
    Child convertDto(ChildDto childDto);
}
