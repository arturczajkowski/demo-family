package phonebookservicecom.example.demo.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import phonebookservicecom.example.demo.entity.PersonalData;
import phonebookservicecom.example.demo.entity.TelephonNumberType;

import java.util.List;

@Repository
public interface PersonalDataRepository extends CrudRepository<PersonalData,Integer>, JpaSpecificationExecutor<PersonalData> {

    List<PersonalData> findAll(Specification<PersonalData> specification);
    List<PersonalData> findByLastName(String lastName);
    List<PersonalData> findByPhoneNumer(String phoneNumber);
}
