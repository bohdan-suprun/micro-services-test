package ua.suprun.getaway.services.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.suprun.dto.user.UserDto;
import ua.suprun.getaway.services.clients.fallback.UserFallback;

@FeignClient(value = "user", fallback = UserFallback.class)
public interface UserClient {

    @GetMapping("/email")
    UserDto getUserByEmail(@RequestParam("userEmail") String userEmail);
}
