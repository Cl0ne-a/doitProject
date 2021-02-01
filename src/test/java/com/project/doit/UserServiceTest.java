package com.project.doit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testSaveUser(){
        DBUser user = new DBUser();
        user.setUserName("TestName");
        user.setUserPassword("testPASSWORD");
        user.setAge(31);

        DBUser newUser = repo.save(user);
        DBUser existUser = entityManager.find(DBUser.class, newUser.getId());

        assertThat(user.getUserPassword().equals(existUser.getUserPassword()));


  }
}

