package iuh.software.template;

import lombok.Data;

@Data
public class Response<T> {
    protected boolean success;
    protected T body;

    private Response() {}

    public Response(boolean success, T body) {
        this.success = success;
        this.body = body;
    }

    public static <T> Response<T> create(boolean success, T body) {
        return new Response(success, body);
    }

}
