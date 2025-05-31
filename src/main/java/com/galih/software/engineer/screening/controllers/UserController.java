package com.galih.software.engineer.screening.controllers;

import com.galih.software.engineer.screening.dtos.AddUsersRequestDto;
import com.galih.software.engineer.screening.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private static final String ACTION_ADD = "add";

    @PostMapping
    public String addUsers(@RequestBody AddUsersRequestDto addUsersRequestDto) {
        if (ACTION_ADD.equalsIgnoreCase(addUsersRequestDto.getAction())) {
            userService.addUsers(addUsersRequestDto.getCount());
            return addUsersRequestDto.getCount() + " user(s) added";
        }
        return "Invalid action";
    }
}
