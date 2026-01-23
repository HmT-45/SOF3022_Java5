package demoSlide5.service.impl;

import demoSlide5.service.interfaces.CookieService;
import org.springframework.boot.web.server.Cookie;
import org.springframework.stereotype.Service;

@Service
public class CookieServiceImpl implements CookieService {

    @Override
    public Cookie create(String name, String value, int expiry) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public String getValue(String name) {
        return "";
    }
}
