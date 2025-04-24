package org.senuka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinRequest {
    private String streamCode;
    private String uniqueID;
}
