// EventService.java
package pkg1.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pkg1.dto.EventDTO;
import pkg1.model.Event;
import pkg1.repository.EventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final EventRepository eventRepo;
    private final ModelMapper mapper;

    public EventService(EventRepository eventRepo, ModelMapper mapper) {
        this.eventRepo = eventRepo;
        this.mapper = mapper;
    }

    public EventDTO createEvent(EventDTO dto) {
        Event entity = mapper.map(dto, Event.class);
        Event saved = eventRepo.save(entity);
        return mapper.map(saved, EventDTO.class);
    }

    public List<EventDTO> getByTeacher(Long teacherId) {
        return eventRepo.findByTeacherId(teacherId)
            .stream()
            .map(e -> mapper.map(e, EventDTO.class))
            .collect(Collectors.toList());
    }
}
