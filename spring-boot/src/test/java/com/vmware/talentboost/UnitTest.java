package com.vmware.talentboost;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UnitTest {

    @Autowired
    MockMvc mvc;

    // https://docs.spring.io/spring-security/site/docs/4.2.x/reference/html/test-method.html

    @Test
    @WithMockUser(username = "talent", roles = { "PARTICIPANT" })
    public void testUserWithParticipantRoleOnly() throws Exception {
        mvc.perform(get("/talent-boost/mentors"))
                .andExpect(status().isForbidden());
        mvc.perform(get("/talent-boost"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "mentor-talent", roles = {"PARTICIPANT", "MENTOR"})
    public void testUserWithMentorAndParticipantRole() throws Exception {
        mvc.perform(get("/talent-boost"))
                .andExpect(status().isOk());
        mvc.perform(get("/talent-boost/mentors"))
                .andExpect(status().isOk());
    }

}
