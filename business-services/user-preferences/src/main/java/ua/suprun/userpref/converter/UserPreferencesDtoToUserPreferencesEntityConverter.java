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
public class UserPreferencesDtoToUserPreferencesEntityConverter implements Converter<UserPreferencesDto, UserPreferencesEntity>
{

    @Override
    public UserPreferencesEntity convert(UserPreferencesDto userPreferencesDto)
    {
        final UserPreferencesEntity userPreferencesEntity = new UserPreferencesEntity();
        userPreferencesEntity.setFilmId(userPreferencesDto.getFilmId());
        userPreferencesEntity.setUserId(userPreferencesDto.getUserId());
        
        return userPreferencesEntity;
    }
}
