package ua.suprun.films.controller.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import ua.suprun.dto.films.FilmDto;
import ua.suprun.films.service.FilmService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilmAmqpController
{
    @Autowired
    private FilmService filmService;
    @Autowired
    private ConversionService conversionService;

    @RabbitListener(queues = "#{getFilmsByIdQueue.name}")
    @SendTo
    public List<FilmDto> getFilms(List<Long> ids)
    {
        return filmService.findFilmsById(ids)
            .stream()
            .map(filmEntity -> conversionService.convert(filmEntity, FilmDto.class))
            .collect(Collectors.toList());
    }
}
