package org.senuka.service.impl;

import org.senuka.dto.Call;
import org.senuka.service.CallService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CallServiceImpl implements CallService {

    @Override
    public Call addCall(Call call) {
        return null;
    }

    @Override
    public Call updateCall(Call call) {
        return null;
    }

    @Override
    public Boolean deleteCall(Long id) {
        return null;
    }

    @Override
    public List<Call> getAllByRoomID(Long id) {
        return null;
    }
}
