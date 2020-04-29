package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.controllers.Service.SearchNames;
import guru.springframework.sfgpetclinic.controllers.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.controllers.fauxspring.Names;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;

class VetControllerTest {

    private VetService vetService;
    private SpecialtyService specialtyService;


    private Names names;

    private VetController vetController;

    @BeforeEach
    void setUp() {

        names = new Names();



    }

//    @BeforeEach
//    void setUp() {
//
//        specialtyService = new SpecialityMapService();
//
//        vetService = new VetMapService(specialtyService);
//
//        vetController = new VetController(vetService);
//
//        Vet bob01 = new Vet(1l, "Patroclos", "Bornn", null);
//
//        Vet bob02 = new Vet(2l, "Michael", "Smith", null);
//
//        vetService.save(bob01);
//        vetService.save(bob02);
//    }

    @Test
    void listVets() {

        Model model = new ModelMapImpl();

        String view = vetController.listVets(model);

        assertThat("vets/index").isEqualTo(view);

        Set modelImpl = (Set) ((ModelMapImpl) model).getMap().get("vets");

        assertThat(modelImpl.size()).isEqualTo(2);


    }

    @RepeatedTest(value = 10, name = LONG_DISPLAY_NAME)
    @DisplayName("Pika of Galaxy Test")
    void myRepeatedTest(){

        System.out.println("Do something");
        System.out.println( names.getName());
    }
}