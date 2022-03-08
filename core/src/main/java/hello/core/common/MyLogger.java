package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.printf("[%s][%s]%s\n", uuid, requestURL, message);
    }

    @PostConstruct
    public void init() {
        String uuid = UUID.randomUUID().toString();
        System.out.printf("[%s] request scope bean create: %s", uuid, this.toString());
    }

    @PreDestroy
    public void close() {
        System.out.printf("[%s] request scope bean close: %s", uuid, this.toString());
    }
}
