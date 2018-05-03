package org.kdsoft.repositories;

import org.kdsoft.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long>{

}
