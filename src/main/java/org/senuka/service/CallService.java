package org.senuka.service;

import org.senuka.dto.Call;

import java.util.List;

public interface CallService {
    Call addCall(Call call);
    Call updateCall(Call call);
    Boolean deleteCall(Long id);
    List<Call> getAllByRoomID(Long id);
}
