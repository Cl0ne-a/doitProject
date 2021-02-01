package com.project.doit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "dbuser", path = "dbuser")
public interface UserRepository extends JpaRepository<DBUser, Integer> {

    DBUser findByAge(int age);

    Iterable<DBUser> findAllByAgeAfter(@Param("age") int age);


    DBUser findById(@Param("id")int id);

    int countDBUserById(@Param("id")int id);

    DBUser findByUserName(@Param("user_name") String userName);
}
