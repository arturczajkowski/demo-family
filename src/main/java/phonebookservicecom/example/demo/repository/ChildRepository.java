package phonebookservicecom.example.demo.repository;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import phonebookservicecom.example.demo.entity.Child;

import java.util.List;

@Repository
public interface ChildRepository extends CrudRepository<Child,Integer>, JpaSpecificationExecutor<Child> {

    List<Child> findAll(Specification<Child> specification);
    List<Child> findByLastName(String lastName);

}
