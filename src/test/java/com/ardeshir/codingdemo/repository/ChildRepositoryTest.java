package com.ardeshir.codingdemo.repository;

import com.ardeshir.codingdemo.model.Child;
import com.ardeshir.codingdemo.model.Person;
import org.hibernate.boot.model.source.internal.hbm.EmbeddableSourceVirtualImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class ChildRepositoryTest {

    @Autowired
    ChildRepository childRepository;
    @Autowired
    PersonRepository personRepository;
    @Test
    public void getChildrenByChildParentAndDeleteChildrenTest()
    {
        Person person=personRepository.findByPersonName("Cloe");
        assertThat(childRepository.getChildrenByChildParent(person).size(),is(2));
        childRepository.deleteAllByChildParent(person);
        assertThat(childRepository.getChildrenByChildParent(person).size(),is(0));
    }
}
