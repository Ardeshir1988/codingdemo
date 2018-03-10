package com.ardeshir.codingdemo.Utils;

import com.ardeshir.codingdemo.repository.PersonRepository;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class CachingTest {

    @Autowired
    PersonRepository personRepository;
    @Test
    public void personCacheTest() {
        personRepository.findAll();
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("com.ardeshir.codingdemo.model.Person").getSize();
        assertThat(size, greaterThan(0));
    }
}
