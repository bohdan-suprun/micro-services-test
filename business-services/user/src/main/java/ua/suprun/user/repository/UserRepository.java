package ua.suprun.user.repository;

import org.springframework.data.repository.CrudRepository;
import ua.suprun.user.entity.UserEntity;

/**
 * Class UserRepository implementation.
 *
 * @author Bohdan_Suprun
 */
public interface UserRepository extends CrudRepository<UserEntity, Long>
{
    UserEntity findUserByEmailIgnoreCase(String email);
}
