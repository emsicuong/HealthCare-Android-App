package com.example.nhom_10_chuong_trinh_android;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.nhom_10_chuong_trinh_android.main.activity.BMIIndexActivity;
import com.example.nhom_10_chuong_trinh_android.main.activity.CaloriesActivity;
import com.example.nhom_10_chuong_trinh_android.main.dao.ProfileDAO;
import com.example.nhom_10_chuong_trinh_android.main.model.Profile;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 28)
public class CaloriesUnitTest {

    @Mock
    ProfileDAO profileDAO;

    @Mock
    Profile profile;

    private CaloriesActivity caloriesActivity;

    @Before
    public void setup() {
        // Khởi tạo mock object
        MockitoAnnotations.initMocks(this);

        // Khởi tạo CaloriesActivity và inject mock ProfileDAO
        caloriesActivity = new CaloriesActivity();
        caloriesActivity.profileDAO = profileDAO;
    }

    @Test
    public void testGetStatusFromAgeGroup_Children_Male_NoDiseases() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Children");
        when(profileDAO.getProfile()).thenReturn(profile);
        when(profile.getSex()).thenReturn("Male");

        ArrayList<String> diseases = new ArrayList<>();
        String result = caloriesActivity.getStatusFromAgeGroup(1500, diseases);

        // Kiểm tra kết quả trả về
        assertEquals("Balance", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Youth_Female_WithDiabetes() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Youth");
        when(profileDAO.getProfile()).thenReturn(profile);
        when(profile.getSex()).thenReturn("Female");

        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Diabetes"));
        String result = caloriesActivity.getStatusFromAgeGroup(1700, diseases);

        // Kiểm tra kết quả trả về
        assertEquals("Balance", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Adolescent_Male_HighBloodPressure() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Adolescent");
        when(profileDAO.getProfile()).thenReturn(profile);
        when(profile.getSex()).thenReturn("Male");

        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("High blood pressure"));
        String result = caloriesActivity.getStatusFromAgeGroup(2500, diseases);

        // Kiểm tra kết quả trả về
        assertEquals("Balance", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Seniors_Female_WithNoDisease() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Old");
        when(profileDAO.getProfile()).thenReturn(profile);
        when(profile.getSex()).thenReturn("Female");

        ArrayList<String> diseases = new ArrayList<>();
        String result = caloriesActivity.getStatusFromAgeGroup(1800, diseases);

        // Kiểm tra kết quả trả về
        assertEquals("Balance", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_MiddleAge_Female_WithFatigue() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Middle-age");
        when(profileDAO.getProfile()).thenReturn(profile);
        when(profile.getSex()).thenReturn("Female");

        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Fatigue"));
        String result = caloriesActivity.getStatusFromAgeGroup(2100, diseases);

        // Kiểm tra kết quả trả về
        assertEquals("Balance", result);
    }

}
