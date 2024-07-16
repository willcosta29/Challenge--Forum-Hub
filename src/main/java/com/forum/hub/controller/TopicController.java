package com.forum.hub.controller;

import com.forum.hub.dto.TopicRequestDTO;
import com.forum.hub.dto.TopicResponseDTO;
import com.forum.hub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping
    public ResponseEntity<?> createTopic(@RequestBody @Valid TopicRequestDTO topicRequestDTO) {
        TopicResponseDTO topicResponseDTO = topicService.saveTopic(topicRequestDTO);
        if (topicResponseDTO == null) {
            return ResponseEntity.badRequest().body("{\"error_message\": \"Topic already exists\", \"status\": 400}");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(topicResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<TopicResponseDTO>> getTopics() {
        return ResponseEntity.status(HttpStatus.OK).body(topicService.getTopics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> getTopic(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        TopicResponseDTO topicResponseDTO = topicService.getTopic(id);
        if (topicResponseDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(topicResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTopic(@RequestBody @Valid TopicRequestDTO topicRequestDTO, @PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        TopicResponseDTO topicResponseDTO = topicService.updateTopic(topicRequestDTO, id);
        if (topicResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error_message\": \"Topic does not exists\", \"status\": 404}");
        }
        return ResponseEntity.status(HttpStatus.OK).body(topicResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

}
