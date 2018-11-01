package ua.suprun.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class UserEntity implementation.
 *
 * @author Bohdan_Suprun
 */
@Data
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntityWithId
{
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
