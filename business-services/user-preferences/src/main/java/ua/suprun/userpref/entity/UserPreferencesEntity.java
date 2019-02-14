package ua.suprun.userpref.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class UserPreferencesEntity implementation.
 *
 * @author Bohdan_Suprun
 */
@Data
@Entity
@Table(name = "user_preferences")
@IdClass(UserPreferencesEntity.class)
public class UserPreferencesEntity implements Serializable
{
    @Id
    protected Long filmId;
    @Id
    protected Long userId;
}
