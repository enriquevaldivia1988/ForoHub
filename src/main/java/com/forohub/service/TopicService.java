package com.forohub.service;

import com.forohub.domain.Topic;
import com.forohub.dto.TopicDTO;
import com.forohub.dto.TopicResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopicService {
    Topic createTopic(TopicDTO topicDTO);
    Topic getTopicById(Long id);

    Page<TopicResponseDTO> getTopics(Pageable pageable);

    Page<TopicResponseDTO> getTopicsByCourseAndYear(String courseName, int year, Pageable pageable);

    List<Topic> getAllTopics();
    void deleteTopic(Long id);
}
