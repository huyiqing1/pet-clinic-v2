package springframework.pracitce.Services.SpringDataJPA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springframework.pracitce.Models.Owner;
import springframework.pracitce.Repositories.OwnerRepository;
import springframework.pracitce.Repositories.PetRepository;
import springframework.pracitce.Repositories.PetTypeRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJPAService service;

    Owner owner1;
    Owner owner2;

    @BeforeEach
    void setUp() {
        Owner defaultOwner = Owner.builder().city("Shanghai").build();
        defaultOwner.setLastName("Peter");
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().city("Toronto").build());
        ownerSet.add(Owner.builder().city("Ottawa").build());

        for (Owner o : ownerSet) {
            System.out.println(o.getCity());
            service.save(o);
        }
        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        owner1 = Owner.builder().city("Toronto").build();
        owner1.setLastName("Smith");
        owner2 = Owner.builder().city("Ottawa").build();
        owner2.setLastName("John");
        service.save(owner1);
        service.save(owner2);

        when(service.findByLastName((any()))).thenReturn(owner1);

        Owner owner = service.findByLastName("Smith");
        assertEquals("Smith", owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}