package springframework.pracitce.Repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.pracitce.Models.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
