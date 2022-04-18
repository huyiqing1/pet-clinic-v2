package springframework.pracitce.Repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.pracitce.Models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
