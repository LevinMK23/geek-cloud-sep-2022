package com.geekbrainss.model;

import lombok.Getter;

@Getter
public class DeleteFile implements CloudMessage{

    private final String fileName;

    public DeleteFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public MessageType getType() {
        return MessageType.DEL_FILE;
    }
}