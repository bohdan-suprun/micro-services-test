package ua.suprun.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Class AbstractEntityWithId implementation.
 *
 * @author Bohdan_Suprun
 */
@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public class AbstractEntityWithId implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
