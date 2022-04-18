package springframework.pracitce.Repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.pracitce.Models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
