package com.vmware.talentboost.web;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talent-boost")
public class SecuredController {

    // Use @PreAuthorize
    // https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html

    @PreAuthorize("hasAnyRole('PARTICIPANT', 'MENTOR')")
    @GetMapping
    // Should have the role PARTICIPANT/MENTOR to access
    public String talentBoostParticipants(Principal principal) {
        return "Hello, " + principal.getName() + ", congratulations on being part of TalentBoost!";
    }

    @PreAuthorize("hasRole('MENTOR')")
    @GetMapping("/mentors")
    // Should have the role MENTOR to access
    public String mentors(Principal principal) {
        return "Hello, " + principal.getName() + ", thank you for your mentoring!";
    }
}
