package com.SCM_Project.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String content;
    
    @Builder.Default
    private MessageType type = MessageType.blue;


}
