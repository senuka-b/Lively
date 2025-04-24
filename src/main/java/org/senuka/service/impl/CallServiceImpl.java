package org.senuka.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.senuka.dto.Call;
import org.senuka.entity.CallEntity;
import org.senuka.entity.StreamEntity;
import org.senuka.repository.CallRepository;
import org.senuka.service.CallService;
import org.senuka.service.StreamService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class CallServiceImpl implements CallService {

    private final CallRepository repository;
    private final ModelMapper mapper;

    private final StreamService streamService;

    @Override
    public Call addCall(Call call) {
        CallEntity savedEntity = repository.save(mapper.map(call, CallEntity.class));
        return mapper.map(savedEntity, Call.class);
    }

    @Override
    public Call updateCall(Call call) {
        if (!repository.existsById(call.getId())) {
            throw new RuntimeException("Call with ID " + call.getId() + " does not exist");
        }

        CallEntity updatedEntity = repository.save(mapper.map(call, CallEntity.class));
        return mapper.map(updatedEntity, Call.class);
    }

    @Override
    public Boolean deleteCall(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Call> getAllByRoomID(Long id) {
        StreamEntity streamEntity = mapper.map(streamService.getRoomById(id), StreamEntity.class);

        if (streamEntity == null) throw new RuntimeException("Room with ID " + id + " does not exist");

        List<CallEntity> callEntities = repository.findAllByRoom(streamEntity);
        return callEntities.stream()
                .map(callEntity -> mapper.map(callEntity, Call.class))
                .toList();
    }


}
