package com.wcappel.ffbackend.misc;

public class DraftFeedMessage {
    private String message;
    private String timestamp;
    private messageType messageType;

    public enum messageType {
        DRAFT_STATUS,
        CURRENT_PICK,
        PICK_RESULT
    }

    public DraftFeedMessage(final String message, final String timestamp, messageType mt) {
        this.message = message;
        this.timestamp = timestamp;
        this.messageType = mt;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public DraftFeedMessage.messageType getMessageType() {
        return messageType;
    }

    @Override
    public String toString() {
        return "DraftFeedMessage{" +
                "message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", messageType=" + messageType +
                '}';
    }
}
