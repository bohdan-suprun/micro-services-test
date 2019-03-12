package ua.suprun.user.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.suprun.user.entity.UserEntity;
import ua.suprun.user.repository.UserRepository;
import ua.suprun.user.service.UserService;

import java.util.Collection;
import java.util.List;

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

    @Override
    public Collection<UserEntity> findUsersById(List<Long> id)
    {
        return Lists.newArrayList(userRepository.findAllById(id));
    }

    @Override
    public UserEntity findUserByEmail(String email)
    {
        return userRepository.findUserByEmailIgnoreCase(email);
    }
}
