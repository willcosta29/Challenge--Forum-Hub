package com.forum.hub.service;

import com.forum.hub.dto.TopicRequestDTO;
import com.forum.hub.dto.TopicResponseDTO;
import com.forum.hub.model.TopicModel;
import com.forum.hub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public TopicResponseDTO saveTopic(TopicRequestDTO dto) {
        TopicModel topicModel = new TopicModel().fromDTO(dto);
        Optional<TopicModel> topic = topicRepository.findByTitleAndMessage(topicModel.getTitle(), topicModel.getMessage());
        if (topic.isPresent()) {
            return null;
        }
        topicModel = topicRepository.save(topicModel);
        return new TopicResponseDTO(topicModel);
    }

    public List<TopicResponseDTO> getTopics() {
        List<TopicModel> topicModels = topicRepository.findAll();
        return topicModels.stream().map(TopicResponseDTO::new).toList();
    }

    public TopicResponseDTO getTopic(Long id) {
        Optional<TopicModel> topic = topicRepository.findById(id);
        return topic.map(TopicResponseDTO::new).orElse(null);
    }

    public TopicResponseDTO updateTopic(TopicRequestDTO topicRequestDTO, Long id) {
        Optional<TopicModel> topic = topicRepository.findById(id);
        return topic.map(topicModel -> new TopicResponseDTO(topicRepository.save(topicModel.fromDTO(topicRequestDTO)))).orElse(null);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
