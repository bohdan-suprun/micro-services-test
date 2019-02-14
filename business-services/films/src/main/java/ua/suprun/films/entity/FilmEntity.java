package ua.suprun.films.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class FilmEntity implementation.
 *
 * @author Bohdan_Suprun
 */
@Data
@Entity
@Table(name = "films")
public class FilmEntity extends AbstractEntityWithId
{
    private String name;
    private String countries;
    private Integer year;
}
