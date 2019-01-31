package ua.suprun.userpref.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.suprun.dto.userpref.UserPreferencesDto;
import ua.suprun.userpref.entity.UserPreferencesEntity;

/**
 * Class UserEntityToUserDtoConverter implementation.
 *
 * @author Bohdan_Suprun
 */
@Component
public class UserPreferencesEntityToUserPreferencesDtoConverter implements Converter<UserPreferencesEntity, UserPreferencesDto>
{

    @Override
    public UserPreferencesDto convert(UserPreferencesEntity userPreferencesEntity)
    {
        final UserPreferencesDto userPreferencesDto = new UserPreferencesDto();
        userPreferencesDto.setFilmId(userPreferencesEntity.getFilmId());
        userPreferencesDto.setUserId(userPreferencesEntity.getUserId());

        return userPreferencesDto;
    }
}
