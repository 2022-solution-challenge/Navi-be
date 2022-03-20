package com.google.solution.route;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    private String roomId;
    private String writer;
    private String message;

    public MessageDto() {
    }

    public MessageDto(String roomId, String writer, String message) {
        this.roomId = roomId;
        this.writer = writer;
        this.message = message;
    }
}
