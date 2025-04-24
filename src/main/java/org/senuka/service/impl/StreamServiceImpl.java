package org.senuka.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.senuka.dto.Stream;
import org.senuka.dto.User;
import org.senuka.entity.StreamEntity;
import org.senuka.entity.UserEntity;
import org.senuka.repository.StreamRepository;
import org.senuka.repository.UserRepository;
import org.senuka.service.StreamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamServiceImpl implements StreamService {

    private final StreamRepository repository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public List<Stream> getAllRooms() {
        return repository.findAll().stream().map(roomEntity -> mapper.map(roomEntity, Stream.class)).toList();
    }

    @Override
    public Stream getRoomById(Long id) {
        StreamEntity streamEntity = repository.findById(id).orElse(null);

        return streamEntity == null ? null : mapper.map(streamEntity, Stream.class);
    }

    @Override
    public Stream createRoom(Stream stream) {
        if (repository.existsByCode(stream.getCode())) {
            throw new RuntimeException("Room with code " + stream.getCode() + " already exists");
        }

        UserEntity userEntity = userRepository.findById(stream.getOwner().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        StreamEntity entity = mapper.map(stream, StreamEntity.class);

        entity.setOwner(userEntity);

        return mapper.map(repository.save(entity), Stream.class);
    }

    @Override
    public Stream updateRoom(Stream stream) {
        if (repository.existsById(stream.getId())) {
            throw new RuntimeException("Room with ID " + stream.getId() + " does not exist");
        }

        return mapper.map(repository.save(mapper.map(stream, StreamEntity.class)), Stream.class);
    }

    @Override
    public void deleteRoom(Long id) {
        repository.deleteById(id);
    }
}
