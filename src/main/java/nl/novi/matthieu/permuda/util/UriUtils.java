package nl.novi.matthieu.permuda.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

public class UriUtils {

    public static URI createUri(int id) {
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest().path("/" + id)
                        .toUriString());
        return uri;
    }
}
