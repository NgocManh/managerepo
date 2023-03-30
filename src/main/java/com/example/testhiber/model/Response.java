package com.example.testhiber.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class Response {
    int status;
    String massage;

    public Response(int status, String massage) {
        this.status = status;
        this.massage = massage;
    }


}
