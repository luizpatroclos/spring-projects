package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void delete() {

        Visit visit = new Visit();

        //it can be like that
        service.delete(visit);

        //or like that both are doing the same
        service.delete(any(Visit.class));

        //verify(visitRepository, times(1)).delete(any(Visit.class)); -- better way
        verify(visitRepository, times(1)).delete(visit);

    }

    @Test
    void deleteById() {
        service.deleteById(3l);
        verify(visitRepository).deleteById(anyLong());
    }

    @Test
    void findById() {

        Visit visit = new Visit();
        when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

       Visit visit1 = service.findById(anyLong());

        verify(visitRepository).findById(anyLong());

       assertThat(visit1).isInstanceOf(Visit.class);

    }

    @Test
    void findAll() {

        Visit visit = new Visit();

        Set<Visit> visitSet = new HashSet<>();
        visitSet.add(visit);

        when(visitRepository.findAll()).thenReturn(visitSet);

        Set<Visit> foundVisits = service.findAll();

        verify(visitRepository).findAll();

        assertThat(foundVisits).hasSize(1);

    }

    @Test
    void save() {
        Visit visit = new Visit();

        //when(visitRepository.save(any(Visit.class))).thenReturn(visit); -- Better way !
        when(visitRepository.save(visit)).thenReturn(new Visit());

        //Visit visit1 = service.save(new Visit()); -- Different as well
        Visit visit1 = service.save(visit);

        //verify(visitRepository).save(any(Visit.class)); -- Using "any" is better
        verify(visitRepository).save(visit);

        assertThat(visit1).isNotNull();
    }
}