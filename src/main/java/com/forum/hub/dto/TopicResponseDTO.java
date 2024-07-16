package com.forum.hub.dto;

import com.forum.hub.model.TopicModel;

import java.time.LocalDateTime;

public record TopicResponseDTO(
        Long id,
        String title,
        String message,
        LocalDateTime creationTime,
        String topicStatus,
        String author,
        String course) {

    public TopicResponseDTO(TopicModel topicModel) {
        this(topicModel.getId(),
                topicModel.getTitle(),
                topicModel.getMessage(),
                topicModel.getCreationTime(),
                topicModel.getTopicStatus(),
                topicModel.getAuthor(),
                topicModel.getCourse());
    }
}
