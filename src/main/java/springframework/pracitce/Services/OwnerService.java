package springframework.pracitce.Services;

import springframework.pracitce.Models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
