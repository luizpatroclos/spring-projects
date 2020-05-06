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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @Test
    void delete() {

        //given
        Visit visit = new Visit();

        //when
        service.delete(visit);

        //given(service.delete(visit)).willReturn(any(Visit.class));

        //or like that both are doing the same
        //service.delete(any(Visit.class));

        //then
        then(visitRepository).should().delete(any(Visit.class));
        //verify(visitRepository, times(1)).delete(any(Visit.class)); -- better way
        //verify(visitRepository, times(1)).delete(visit);

    }

    @Test
    void deleteById() {

        //given ( BDD )
        // not this case

        //when
        service.deleteById(3l);

        //then ( BDD )
        then(visitRepository).should(times(1)).deleteById(3L);
        //verify(visitRepository).deleteById(anyLong());

    }

    @Test
    void findById() {

        //given ( BDD )
        Visit visit = new Visit();
        given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));
        //when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));

        //when ( BDD )
       Visit visit1 = service.findById(anyLong());

       //then ( BDD )
        then(visitRepository).should().findById(anyLong());
        assertThat(visit1).isInstanceOf(Visit.class);
        //verify(visitRepository).findById(anyLong());

    }

    @Test
    void findAll() {

        // given ( BDD style )
        Visit visit = new Visit();
        Set<Visit> visitSet = new HashSet<>();
        visitSet.add(visit);

        given(visitRepository.findAll()).willReturn(visitSet);
        //when(visitRepository.findAll()).thenReturn(visitSet);

        // when
        Set<Visit> foundVisits = service.findAll();

        //then
        then(visitRepository).should(times(1)).findAll();
        //verify(visitRepository).findAll();
        assertThat(foundVisits).hasSize(1);
    }

    @Test
    void save() {

        //given ( BDD 1)
        Visit visit = new Visit();

        given(visitRepository.save(any(Visit.class))).willReturn(visit);
        //when(visitRepository.save(any(Visit.class))).thenReturn(visit); -- Better way !
        //when(visitRepository.save(visit)).thenReturn(new Visit());

        //when
        Visit visit1 = service.save(new Visit());
        //Visit visit1 = service.save(new Visit()); -- Different as well


        //then
        then(visitRepository).should().save(any(Visit.class));
        assertThat(visit1).isNotNull();
        //verify(visitRepository).save(visit);
        //verify(visitRepository).save(any(Visit.class)); -- Using "any" is better

    }
}