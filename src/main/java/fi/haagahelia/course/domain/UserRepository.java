//Spring UserRepository


package fi.haagahelia.course.domain;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.course.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
User findByUsername(String username);
}
