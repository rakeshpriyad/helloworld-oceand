
package com.test.hello.world.repository;
import com.test.hello.world.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

    @Query("FROM UserDetails user WHERE user.id = :userId")
    Optional<UserDetails> findUserById(@Param("userId") Integer userId);



}
