package com.forohub.service.impl;

import com.forohub.domain.Course;
import com.forohub.domain.Topic;
import com.forohub.domain.User;
import com.forohub.dto.TopicDTO;
import com.forohub.dto.TopicResponseDTO;
import com.forohub.dto.UpdateTopicDTO;
import com.forohub.repository.CourseRepository;
import com.forohub.repository.TopicRepository;
import com.forohub.repository.UserRepository;
import com.forohub.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        Optional<Topic> existingTopic = topicRepository.findByTitleAndMessage(topicDTO.title(), topicDTO.message());
        if (existingTopic.isPresent()) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }

        // Validar que el autor y el curso existen
        User author = userRepository.findById(topicDTO.authorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Course course = courseRepository.findById(topicDTO.courseId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Crear y guardar el tópico
        Topic topic = new Topic();
        topic.setTitle(topicDTO.title());
        topic.setMessage(topicDTO.message());
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
    public void deleteTopic(Long id) {
        // Verificar si el tópico existe
        if (!topicRepository.existsById(id)) {
            throw new IllegalArgumentException("El tópico con ID " + id + " no existe.");
        }
        topicRepository.deleteById(id);
    }

    @Override
    public Topic updateTopic(Long id, @Valid UpdateTopicDTO updateTopicDTO) {
        // Verificar si el tópico existe
        Optional<Topic> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isEmpty()) {
            throw new IllegalArgumentException("El tópico con ID " + id + " no existe.");
        }

        // Verificar si hay duplicados (título y mensaje)
        Optional<Topic> existingTopic = topicRepository.findByTitleAndMessage(updateTopicDTO.title(), updateTopicDTO.message());
        if (existingTopic.isPresent() && !existingTopic.get().getId().equals(id)) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }

        // Actualizar el tópico
        Topic topic = optionalTopic.get();
        topic.setTitle(updateTopicDTO.title());
        topic.setMessage(updateTopicDTO.message());

        return topicRepository.save(topic);
    }
}
