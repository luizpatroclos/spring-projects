package guru.springframework.sfgpetclinic.controllers.fauxspring;

import guru.springframework.sfgpetclinic.controllers.Service.SearchNames;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Names implements SearchNames {


    @Override
    public String getName() {

        String[] value = new String[]{"Jhon", "Marko", "Jason", "Robert", "Nicolas", "Peter", "Gabriel", "Kin", "Joshua", "Kevin", "Smith"};

        ArrayList<String> values = (ArrayList<String>) Arrays.stream(value);


        return RandomStringUtils.random(values.size());
    }
}
