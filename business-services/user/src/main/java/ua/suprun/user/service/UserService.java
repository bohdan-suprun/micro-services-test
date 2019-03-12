package ua.suprun.user.service;

import ua.suprun.user.entity.UserEntity;

import java.util.Collection;
import java.util.List;

/**
 * Class UserService implementation.
 *
 * @author Bohdan_Suprun
 */
public interface UserService
{
    UserEntity createUser(UserEntity userEntity);

    UserEntity findUserById(Long id);

    Collection<UserEntity> findUsersById(List<Long> ids);

    UserEntity findUserByEmail(String email);
}
