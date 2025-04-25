package org.senuka.controller;

import lombok.RequiredArgsConstructor;
import org.senuka.dto.Stream;
import org.senuka.service.StreamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/streams")
@RequiredArgsConstructor
public class StreamController {

    private final StreamService streamService;

    @GetMapping
    public ResponseEntity<List<Stream>> getAllRooms() {
        List<Stream> streams = streamService.getAllRooms();

        return streams.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(streams);
    }

    @GetMapping("/{streamCode}")
    public ResponseEntity<Stream> getRoomByCode(@PathVariable String streamCode) {
        Stream streamByCode = streamService.getStreamByCode(streamCode);

        return streamByCode == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(streamByCode);
    }

    @PostMapping
    public ResponseEntity<Stream> createRoom(@RequestBody Stream stream) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(streamService.createRoom(stream));

        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{streamID}")
    public ResponseEntity<Stream> updateRoom(@PathVariable Long streamID, @RequestBody Stream stream) {
        stream.setId(streamID);
        return ResponseEntity.ok(streamService.updateRoom(stream));
    }

    @DeleteMapping("/{streamID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable Long streamID) {
        streamService.deleteRoom(streamID);
    }
}
