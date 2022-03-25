package com.google.solution.route.chatroom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
public class RoomController {

    private final ChatRoomRepository chatRoomRepository;

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public String rooms(Model model){
        model.addAttribute("list", chatRoomRepository.findAll());
        return "room-list";
    }
    @GetMapping(value = "/rooms/{roomId}")
    public String rooms(@PathVariable String roomId, Model model){
        System.out.println(roomId);
        ChatRoom room = chatRoomRepository.findById(UUID.fromString(roomId)).orElseThrow(IllegalAccessError::new);
        model.addAttribute("room", room);
        model.addAttribute("member", "eungi");
        return "room";
    }

    @PostMapping(value = "/rooms")
    public String createRooms(String name, Model model){
        chatRoomRepository.save(new ChatRoom(name));
        return "redirect:/chat/rooms";
    }

}
