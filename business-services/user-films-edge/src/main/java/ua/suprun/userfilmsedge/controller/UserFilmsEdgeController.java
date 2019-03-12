package ua.suprun.userfilmsedge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.suprun.dto.userfilmsedge.UserFilmsDto;
import ua.suprun.dto.userfilmsedge.UsersLikedFilmDto;
import ua.suprun.userfilmsedge.service.impl.UserFilmsServiceImpl;

@RestController
public class UserFilmsEdgeController
{
    @Autowired
    private UserFilmsServiceImpl userFilmsService;

    @GetMapping("/user/{userId}/films/liked")
    public UserFilmsDto getLikedFilms(@PathVariable("userId") Long userId) throws Exception
    {
        return userFilmsService.getUserFilms(userId);
    }

    @GetMapping("/film/{filmId}/users/liked")
    public UsersLikedFilmDto getUsersLikedFilm(@PathVariable("filmId") Long filmId) throws Exception
    {
        return userFilmsService.getUsersLikedFilm(filmId);
    }
}
