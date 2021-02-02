package com.infoshare.service;

import com.infoshare.model.ActivityDTO;
import com.infoshare.model.Category;
import com.infoshare.model.Priority;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ActivityServiceTest {

    private ActivityService activityService;

    @BeforeEach
    void setUp() {
        activityService = new ActivityService();
    }

    @AfterEach
    void tearDown() {
        activityService = null;
    }

    @Test
    void shouldBeTrueIfAddMethodWorks() {
        //given
        ActivityDTO newActivity = new ActivityDTO();
        newActivity.setDescription("Do a buckling analysis");
        newActivity.setCategory(Category.WORK);
        newActivity.setPriority(Priority.URGENT);
        newActivity.setDeadline(LocalDate.of(2021,2,27));

        //when
        activityService.addActivity(newActivity);
        List<ActivityDTO> updateList = activityService.getAllActivities();

        //then
        assertThat(updateList).contains(newActivity);
            }
}