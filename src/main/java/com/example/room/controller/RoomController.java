package com.example.room.controller;


import com.example.room.model.Rooms;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@Controller
public class RoomController {
    @GetMapping("/rooms")
    @PreAuthorize("hasRole('USER')")
    public ModelAndView listRoom(){
        return new
                ModelAndView("rooms/list");
    }

    @GetMapping("/create-room")
    @PreAuthorize("hasRole('HOST')")
    public ModelAndView createRoom(){
        return new
                ModelAndView("rooms/create");
    }
}
