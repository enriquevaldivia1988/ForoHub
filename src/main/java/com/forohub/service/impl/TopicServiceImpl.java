package com.forohub.service.impl;

import com.forohub.domain.Course;
import com.forohub.domain.Topic;
import com.forohub.domain.User;
import com.forohub.dto.TopicDTO;
import com.forohub.dto.TopicResponseDTO;
import com.forohub.repository.CourseRepository;
import com.forohub.repository.TopicRepository;
import com.forohub.repository.UserRepository;
import com.forohub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Topic createTopic(TopicDTO topicDTO) {
        // Verificar duplicados
        Optional<Topic> existingTopic = topicRepository.findByTitleAndMessage(topicDTO.getTitle(), topicDTO.getMessage());
        if (existingTopic.isPresent()) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }

        // Validar que el autor y el curso existen
        User author = userRepository.findById(topicDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Course course = courseRepository.findById(topicDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Crear y guardar el tópico
        Topic topic = new Topic();
        topic.setTitle(topicDTO.getTitle());
        topic.setMessage(topicDTO.getMessage());
        topic.setAuthor(author);
        topic.setCourse(course);
        return topicRepository.save(topic);
    }

    @Override
    public Topic getTopicById(Long id) {
        return topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    @Override
    public Page<TopicResponseDTO> getTopics(Pageable pageable) {
        return topicRepository.findAll(pageable)
                .map(topic -> new TopicResponseDTO(
                        topic.getTitle(),
                        topic.getMessage(),
                        topic.getCreatedAt(),
                        topic.getStatus().name(),
                        topic.getAuthor().getName(),
                        topic.getCourse().getName()
                ));
    }

    @Override
    public Page<TopicResponseDTO> getTopicsByCourseAndYear(String courseName, int year, Pageable pageable) {
        return topicRepository.findByCourseNameAndYear(courseName, year, pageable)
                .map(topic -> new TopicResponseDTO(
                        topic.getTitle(),
                        topic.getMessage(),
                        topic.getCreatedAt(),
                        topic.getStatus().name(),
                        topic.getAuthor().getName(),
                        topic.getCourse().getName()
                ));
    }


    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
