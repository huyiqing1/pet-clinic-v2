package springframework.pracitce.Services.Map;

import org.springframework.stereotype.Service;
import springframework.pracitce.Models.Speciality;
import springframework.pracitce.Services.SpecialtyService;

import java.util.Set;

@Service
public class SpecialtyServiceMap extends AbstractServiceMap<Speciality, Long> implements SpecialtyService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
