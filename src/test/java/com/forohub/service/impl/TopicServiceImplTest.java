//package com.forohub.service.impl;
//
//import com.forohub.domain.Course;
//import com.forohub.domain.Topic;
//import com.forohub.domain.User;
//import com.forohub.dto.TopicDTO;
//import com.forohub.repository.CourseRepository;
//import com.forohub.repository.TopicRepository;
//import com.forohub.repository.UserRepository;
//import com.forohub.service.TopicService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class TopicServiceTest {
//
//    private TopicRepository topicRepository;
//    private UserRepository userRepository;
//    private CourseRepository courseRepository;
//    private TopicService topicService;
//
//    @BeforeEach
//    void setUp() {
//        topicRepository = mock(TopicRepository.class);
//        userRepository = mock(UserRepository.class);
//        courseRepository = mock(CourseRepository.class);
//        topicService = new TopicService(topicRepository, userRepository, courseRepository) {
//            @Override
//            public Topic createTopic(TopicDTO topicDTO) {
//                return null;
//            }
//
//            @Override
//            public Topic getTopicById(Long id) {
//                return null;
//            }
//
//            @Override
//            public List<Topic> getAllTopics() {
//                return List.of();
//            }
//
//            @Override
//            public void deleteTopic(Long id) {
//
//            }
//        };
//    }
//
//    @Test
//    void shouldCreateTopicSuccessfully() {
//        // Datos de prueba
//        TopicDTO topicDTO = new TopicDTO();
//        topicDTO.setTitle("Título");
//        topicDTO.setMessage("Mensaje");
//        topicDTO.setAuthorId(1L);
//        topicDTO.setCourseId(1L);
//
//        User author = new User();
//        author.setId(1L);
//
//        Course course = new Course();
//        course.setId(1L);
//
//        when(userRepository.findById(1L)).thenReturn(Optional.of(author));
//        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));
//        when(topicRepository.findByTitleAndMessage("Título", "Mensaje")).thenReturn(Optional.empty());
//
//        Topic createdTopic = topicService.createTopic(topicDTO);
//
//        assertNotNull(createdTopic);
//        assertEquals("Título", createdTopic.getTitle());
//        verify(topicRepository).save(any(Topic.class));
//    }
//}
//
