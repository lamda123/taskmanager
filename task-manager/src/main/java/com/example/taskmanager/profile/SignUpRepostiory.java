package com.example.taskmanager.profile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepostiory  extends CrudRepository<User,String> {
      User save(User u);

      @Query("select case when count(u)> 0 then true else false end from User u where lower(u.email) like lower(:email)")
    // @Query("select IF(count(*) > 1, true, false) as result from User u where lower(u.email) like lower(:email)")
      boolean checkIfAccountExists(@Param("email") String email);
}
