package nl.novi.matthieu.permuda.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

public class UriUtils {

    public static URI createUri(String slug) {
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/" + slug)
                        .toUriString());
        return uri;
    }
}
