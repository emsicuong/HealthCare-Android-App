package com.example.nhom_10_chuong_trinh_android;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.example.nhom_10_chuong_trinh_android.main.activity.CaloriesActivity;
import com.example.nhom_10_chuong_trinh_android.main.activity.HeartHealthActivity;
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
public class HeartHealthUnitTest {

    private HeartHealthActivity heartHealthActivity;

    @Before
    public void setup() {
        // Khởi tạo mock object
        MockitoAnnotations.initMocks(this);

        // Khởi tạo HeartHealthActivity và inject mock ProfileDAO
        heartHealthActivity = new HeartHealthActivity();
    }

    @Test
    public void testGetStatus_Children_Male_NoDiseases_Normal() {
        ArrayList<String> diseases = new ArrayList<>();
        String result = heartHealthActivity.getStatus(diseases, 75.0f, 100.0f, "Children");

        // Kiểm tra kết quả trả về
        assertEquals("Normal", result);
    }

    @Test
    public void testGetStatus_Teenager_Female_Diabetes_High() {
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Diabetes"));
        String result = heartHealthActivity.getStatus(diseases, 100.0f, 140.0f, "Teenager");

        // Kiểm tra kết quả trả về
        assertEquals("High", result);
    }

    @Test
    public void testGetStatus_Adolescent_Male_HighBloodPressure_Low() {
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("High blood pressure"));
        String result = heartHealthActivity.getStatus(diseases, 50.0f, 70.0f, "Adolescent");

        // Kiểm tra kết quả trả về
        assertEquals("Low", result);
    }

    @Test
    public void testGetStatus_MiddleAge_Female_MentalIllness_Normal() {
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Mental illness"));
        String result = heartHealthActivity.getStatus(diseases, 70.0f, 90.0f, "Middle-age");

        // Kiểm tra kết quả trả về
        assertEquals("Normal", result);
    }

    @Test
    public void testGetStatus_Old_Male_NoDiseases_Hypertension() {
        ArrayList<String> diseases = new ArrayList<>();
        String result = heartHealthActivity.getStatus(diseases, 100.0f, 150.0f, "Old");

        // Kiểm tra kết quả trả về
        assertEquals("High", result);
    }

}
