package com.forum.hub.model;

import com.forum.hub.dto.TopicRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "tb_topic")
@Table(name = "tb_topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationTime;
    private String topicStatus;
    private String author;
    private String course;

    public TopicModel fromDTO(TopicRequestDTO topicRequestDTO) {
        TopicModel topicModel = new TopicModel();
        topicModel.setId(0L);
        topicModel.setTitle(topicRequestDTO.title());
        topicModel.setMessage(topicRequestDTO.message());
        topicModel.setCreationTime(LocalDateTime.now());
        topicModel.setTopicStatus("Ativo");
        topicModel.setAuthor(topicRequestDTO.author());
        topicModel.setCourse(topicRequestDTO.course());
        return topicModel;
    }
}
