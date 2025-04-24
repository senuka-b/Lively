package org.senuka.service;

import org.senuka.dto.Stream;

import java.util.List;

public interface StreamService {
    public List<Stream> getAllRooms();
    public Stream getRoomById(Long id);
    public Stream createRoom(Stream stream);
    public Stream updateRoom(Stream stream);
    public void deleteRoom(Long id);
}
