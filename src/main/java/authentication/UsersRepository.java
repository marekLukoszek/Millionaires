package authentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface UsersRepository extends CrudRepository<User, String> {
        User findUserByUsername(String userName);
    }