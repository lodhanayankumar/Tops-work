package com.example.userprofileservice;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class PlaylistErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new ErrorDecoder.Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() == 404) {
            return new PlaylistNotFoundException("playlist not found");
        }

        return defaultDecoder.decode(methodKey, response);
    }
}