package org.senuka.controller;

import lombok.RequiredArgsConstructor;
import org.senuka.dto.Call;
import org.senuka.service.CallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call")
@RequiredArgsConstructor
public class CallController {
    private final CallService service;

    @GetMapping("/all/{roomID}")
    public ResponseEntity<List<Call>> getAllCallsByRoomID(@PathVariable Long roomID) {
        List<Call> calls = service.getAllByRoomID(roomID);

        return calls.isEmpty() ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(calls);
    }

    @PostMapping("/create")
    public ResponseEntity<Call> createCall(@RequestBody Call call) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCall(call));
    }

    @PutMapping("/update")
    public ResponseEntity<Call> updateCall(@RequestBody Call call) {
        Call updateCall = service.updateCall(call);

        return updateCall == null ? ResponseEntity.badRequest().build()
                : ResponseEntity.status(HttpStatus.CREATED).body(updateCall);
    }

    @DeleteMapping("/delete/{callID}")
    public ResponseEntity<Boolean> deleteCall(@PathVariable Long callID) {
        Boolean deleteCall = service.deleteCall(callID);

        return deleteCall ? ResponseEntity.noContent().build()
                : ResponseEntity.badRequest().body(false);
    }
}
