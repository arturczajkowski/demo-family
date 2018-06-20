package phonebookservicecom.example.demo.converters;

import org.springframework.stereotype.Component;
import phonebookservicecom.example.demo.dto.ChildDto;
import phonebookservicecom.example.demo.entity.Child;
import phonebookservicecom.example.demo.entity.Sex;

@Component
public class ChildDtoConverterImpl implements ChildDtoConverter {
    @Override
    public ChildDto convert(Child child) {

        ChildDto childDto = new ChildDto();
      childDto.setId(child.getId());
      childDto.setFirstName(child.getFirstName());
      childDto.setLastName(child.getLastName());
      childDto.setPesel(child.getPesel());
      childDto.setDateOfBirth(child.getDateOfBirth());
      childDto.setType(child.getType().getValue());

       return childDto;

    }

    @Override
    public Child convertDto(ChildDto childDto) {
        return new Child(childDto.getId(), childDto.getFirstName(), childDto.getLastName(),
                childDto.getPesel(),childDto.getDateOfBirth(), Sex.valueOf(childDto.getType()));
    }
}
