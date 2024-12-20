package com.forohub.controller;

import com.forohub.domain.Topic;
import com.forohub.dto.TopicDTO;
import com.forohub.dto.TopicResponseDTO;
import com.forohub.dto.UpdateTopicDTO;
import com.forohub.infra.config.PaginatedResponse;
import com.forohub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;
    private final PagedResourcesAssembler<TopicResponseDTO> pagedResourcesAssembler;

    public TopicController(TopicService topicService, PagedResourcesAssembler<TopicResponseDTO> pagedResourcesAssembler) {
        this.topicService = topicService;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@Valid @RequestBody TopicDTO topicDTO) {
        Topic createdTopic = topicService.createTopic(topicDTO);
        return ResponseEntity.status(201).body(createdTopic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @GetMapping
    public PaginatedResponse<TopicResponseDTO> listTopics(@PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        Page<TopicResponseDTO> topics = topicService.getTopics(pageable);
        return new PaginatedResponse<>(topics);
    }

    @GetMapping("/search")
    public PaginatedResponse<TopicResponseDTO> listTopicsByCourseAndYear(
            @RequestParam String courseName,
            @RequestParam int year,
            @PageableDefault(size = 10, sort = "createdAt") Pageable pageable) {
        Page<TopicResponseDTO> topics = topicService.getTopicsByCourseAndYear(courseName, year, pageable);
        return new PaginatedResponse<>(topics);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTopicDTO updateTopicDTO) {
        Topic updatedTopic = topicService.updateTopic(id, updateTopicDTO);
        return ResponseEntity.ok(updatedTopic);
    }
}
