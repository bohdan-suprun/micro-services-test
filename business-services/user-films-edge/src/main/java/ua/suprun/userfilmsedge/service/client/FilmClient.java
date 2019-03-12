package ua.suprun.userfilmsedge.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ua.suprun.dto.films.CreateFilmDto;
import ua.suprun.dto.films.FilmDto;
import ua.suprun.userfilmsedge.service.client.fallback.FilmClientFallback;

import java.util.Collection;
import java.util.List;

/**
 * Class UserClient implementation.
 *
 * @author Bohdan_Suprun
 */
@FeignClient(value = "film", fallback = FilmClientFallback.class)
public interface FilmClient
{
    @PostMapping("/create")
    FilmDto create(@RequestBody CreateFilmDto createFilmDto);

    @GetMapping("/search")
    Collection<FilmDto> search(@RequestParam("name") String filmName);

    @GetMapping("/{filmId}")
    FilmDto getFilmById(@PathVariable("filmId") Long filmId);

    @PostMapping("/filmsById")
    Collection<FilmDto> getFilmsById(@RequestBody List<Long> filmsId);
}
