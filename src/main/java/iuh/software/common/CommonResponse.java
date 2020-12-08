package iuh.software.common;

import iuh.software.template.Response;
import org.springframework.http.ResponseEntity;

public final class CommonResponse {

    public static ResponseEntity<Response> OK = ResponseEntity.ok(Response.create(true, null));
}
