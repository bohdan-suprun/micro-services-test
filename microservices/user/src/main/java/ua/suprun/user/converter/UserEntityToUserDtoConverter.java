package ua.suprun.user.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.suprun.dto.user.UserDto;
import ua.suprun.user.entity.UserEntity;

/**
 * Class UserEntityToUserDtoConverter implementation.
 *
 * @author Bohdan_Suprun
 */
@Component
public class UserEntityToUserDtoConverter implements Converter<UserEntity, UserDto>
{
    @Override
    public UserDto convert(UserEntity userEntity)
    {
        final UserDto userDto = new UserDto();
        userDto.setEmail(userEntity.getEmail());
        userDto.setFullName(userEntity.getFirstName() + " " + userEntity.getLastName());
        userDto.setId(userEntity.getId());
        userDto.setRole(userEntity.getRole());

        return userDto;
    }
}
