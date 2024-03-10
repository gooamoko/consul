package ru.gooamoko.consul.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gooamoko.consul.OrganizationService;
import ru.gooamoko.consul.model.OrganizationInfo;
import ru.gooamoko.consul.model.ServicesInfo;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    private OrganizationService service;

    public ServicesController(OrganizationService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<ServicesInfo> getServicesList() {
        OrganizationInfo organizationInfo = service.getOrganization();
        if (organizationInfo == null) {
            return ResponseEntity.internalServerError().build();
        } else {
            List<String> services = new LinkedList<>();
            services.add("Настройка серверов");
            services.add("Обслуживание серверов");
            services.add("Прокладка кабеля");
            services.add("Администрирование сетевого оборудования");

            ServicesInfo info = new ServicesInfo();
            info.setOrg(organizationInfo);
            info.setServices(services);
            return ResponseEntity.ok(info);
        }
    }
}
