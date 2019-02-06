package id.web.kulgram.biodata.dao;

import id.web.kulgram.biodata.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
}
