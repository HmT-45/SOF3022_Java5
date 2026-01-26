package demoSlide5.service.interfaces;

import org.springframework.boot.web.server.Cookie;

public interface CookieService {
    Cookie create(String name, String value, int expiry);

    void delete(String name);

    String getValue(String name);
}

