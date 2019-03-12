package ua.suprun.userfilmsedge.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ua.suprun.dto.user.UserCreateDto;
import ua.suprun.dto.user.UserDto;
import ua.suprun.userfilmsedge.service.client.fallback.UserClientFallback;

import java.util.Collection;
import java.util.List;

/**
 * Class UserClient implementation.
 *
 * @author Bohdan_Suprun
 */
@FeignClient(value = "user", fallback = UserClientFallback.class)
public interface UserClient
{
    @PostMapping
    UserDto createUser(@RequestBody UserCreateDto userCreateDto);

    @GetMapping("/{userId}")
    UserDto getUserById(@PathVariable("userId") Long userId);

    @GetMapping("/email")
    UserDto getUserByEmail(@RequestParam("userEmail") String email);

    @PostMapping("/usersById")
    Collection<UserDto> getUsersById(@RequestBody List<Long> userIds);
}
