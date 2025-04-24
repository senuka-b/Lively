package org.senuka.controller;

import lombok.RequiredArgsConstructor;
import org.senuka.dto.Call;
import org.senuka.service.CallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calls")
@RequiredArgsConstructor
public class CallController {

    private final CallService callService;

    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<Call>> getCallsByRoomId(@PathVariable Long roomId) {
        List<Call> calls = callService.getAllByRoomID(roomId);

        return calls.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(calls);
    }

    @PostMapping
    public ResponseEntity<Call> createCall(@RequestBody Call call) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(callService.addCall(call));
    }

    @PutMapping("/{callId}")
    public ResponseEntity<Call> updateCall(@PathVariable Long callId, @RequestBody Call call) {
        call.setId(callId);

        return ResponseEntity.ok(callService.updateCall(call));
    }

    @DeleteMapping("/{callId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCall(@PathVariable Long callId) {
        callService.deleteCall(callId);
    }
}

