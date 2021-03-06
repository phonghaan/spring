package com.logigear.training.security;

import com.logigear.training.model.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ReactiveEmployeeAuthenticationRepository extends ReactiveCrudRepository<Employee, Integer> {
    @Query("SELECT u.id, u.username, u.fullname, u.password, u.is_activated, u.is_signed_out, r.role_name FROM users u JOIN roles r ON u.role_id = r.id WHERE u.username = :username")
    Mono<Employee> findByUsername(String username);

    @Query("SELECT u.id, u.username, u.fullname, u.is_activated, u.is_signed_out, r.role_name FROM users u JOIN roles r ON r.id = u.role_id WHERE u.username = :username")
    Mono<AuthenticationResponse> findAuthenticationResponseByUsername(String username);

    @Query("INSERT INTO users(username, password, fullname, role_id, is_activated, is_signed_out) VALUES (:username, :password, :fullname, 2, false, true)")
    Mono<Employee> signUpAUser(String username, String password, String fullname);

    @Query("UPDATE users SET is_signed_out = true WHERE username = :username")
    Mono<Boolean> changeToSignedOutStatus(String username);

    @Query("UPDATE users SET is_signed_out = false WHERE username = :username")
    Mono<Boolean> changeToSignedInStatus(String username);
}
