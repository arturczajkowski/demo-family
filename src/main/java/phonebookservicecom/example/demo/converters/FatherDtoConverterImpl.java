package phonebookservicecom.example.demo.converters;


import org.springframework.stereotype.Component;
import phonebookservicecom.example.demo.dto.FatherDto;
import phonebookservicecom.example.demo.entity.Father;

@Component
public class FatherDtoConverterImpl implements FatherDtoConverter {
    @Override
    public FatherDto convert(Father father) {

        FatherDto fatherDto = new FatherDto();
        fatherDto.setId(father.getId());
        fatherDto.setFirstName(father.getFirstName());
        fatherDto.setLastName(father.getLastName());
        fatherDto.setPesel(father.getPesel());
        fatherDto.setDateOfBirth(father.getDateOfBirth());
        return fatherDto;
    }

    @Override
    public Father convertDto(FatherDto fatherDto) {

        return new Father(fatherDto.getId(), fatherDto.getFirstName(), fatherDto.getLastName(),
                fatherDto.getPesel(),fatherDto.getDateOfBirth());
    }
}
