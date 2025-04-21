package com.example.training.web.controller;

import com.example.training.data.entity.RoomEntity;
import com.example.training.data.repository.RoomRepository;
import com.example.training.model.Room;
import com.example.training.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getRoomsPage(Model model) {
        model.addAttribute("rooms", this.roomService.getRooms());
        return  "rooms";
    }
}
