package phonebookservicecom.example.demo.repository;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import phonebookservicecom.example.demo.entity.Father;

import java.util.List;

@Repository
public interface FatherRepository extends CrudRepository<Father,Integer>, JpaSpecificationExecutor<Father> {

    List<Father> findAll(Specification<Father> specification);
    List<Father> findByLastName(String lastName);

}
