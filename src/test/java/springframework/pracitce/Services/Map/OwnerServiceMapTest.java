package springframework.pracitce.Services.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springframework.pracitce.Models.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Owner owner1;
    Owner owner2;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        owner1 = Owner.builder().city("Toronto").build();
        owner1.setLastName("aaa");
        owner2 = Owner.builder().city("Ottawa").build();
        owner2.setLastName("ccc");
        ownerServiceMap.save(owner1);
        ownerServiceMap.save(owner2);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(2, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1L);
        assertEquals("Toronto", owner.getCity());
    }

    @Test
    void save() {
        Owner owner3 = ownerServiceMap.save(Owner.builder().city("Shanghai").build());
        assertEquals(3L, owner3.getId());
        assertEquals(3, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(owner2);
        assertEquals(1, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(2L);
        assertEquals(1, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName("aaa");
        assertNotNull(owner);
        assertEquals(1L, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("bbb");
        assertNull(owner);
    }
}