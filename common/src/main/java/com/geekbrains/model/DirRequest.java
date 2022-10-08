package com.geekbrains.model;

import lombok.Getter;
@Getter
public class DirRequest implements CloudMessage {

    private final String dirName;
    public DirRequest(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public MessageType getType() {
        return MessageType.DIR_REQUEST;
    }
}
