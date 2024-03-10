package ru.gooamoko.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gooamoko.consul.config.OrganizationProperties;

@RestController
@RequestMapping("/org")
public class OrgController {
    private final OrganizationProperties properties;

    public OrgController(OrganizationProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/info")
    public OrganizationProperties getOrgInfo() {
        return properties;
    }
}
