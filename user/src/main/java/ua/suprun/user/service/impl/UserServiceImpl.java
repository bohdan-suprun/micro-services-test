package ua.suprun.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.suprun.user.entity.UserEntity;
import ua.suprun.user.repository.UserRepository;
import ua.suprun.user.service.UserService;

/**
 * Class UserServiceImpl implementation.
 *
 * @author Bohdan_Suprun
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity)
    {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findUserById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }
}
