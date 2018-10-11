package ua.suprun.user.service;

import ua.suprun.user.entity.UserEntity;

/**
 * Class UserService implementation.
 *
 * @author Bohdan_Suprun
 */
public interface UserService
{
    UserEntity createUser(UserEntity userEntity);

    UserEntity findUserById(Long id);
}
