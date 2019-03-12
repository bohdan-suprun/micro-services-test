package ua.suprun.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.suprun.dto.user.UserCreateDto;
import ua.suprun.dto.user.UserDto;
import ua.suprun.user.entity.UserEntity;
import ua.suprun.user.service.UserService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class UserController implementation.
 *
 * @author Bohdan_Suprun
 */
@RestController
public class UserController
{
    @Autowired
    private UserService userService;
    @Autowired
    private ConversionService conversionService;

    @PostMapping
    public UserDto createUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        final UserEntity user = userService.createUser(conversionService.convert(userCreateDto,
            UserEntity.class));

        return conversionService.convert(user, UserDto.class);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId) {
        final UserEntity user = userService.findUserById(userId);

        return conversionService.convert(user, UserDto.class);
    }

    @GetMapping("/email")
    public UserDto getUserByEmail(@RequestParam("userEmail") String email) {
        final UserEntity user = userService.findUserByEmail(email);

        return conversionService.convert(user, UserDto.class);
    }

    @PostMapping("/usersById")
    public Collection<UserDto> getUsersById(@RequestBody List<Long> userIds)
    {
        return userService.findUsersById(userIds)
            .stream()
            .map(userEntity -> conversionService.convert(userEntity, UserDto.class))
            .collect(Collectors.toList());
    }
}
