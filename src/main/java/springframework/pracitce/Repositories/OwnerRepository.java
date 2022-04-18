package springframework.pracitce.Repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.pracitce.Models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);


}
