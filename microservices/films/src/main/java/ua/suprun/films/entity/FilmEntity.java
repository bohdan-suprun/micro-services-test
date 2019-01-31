package ua.suprun.films.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

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
