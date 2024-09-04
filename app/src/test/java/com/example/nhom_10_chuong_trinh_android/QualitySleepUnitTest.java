package com.example.nhom_10_chuong_trinh_android;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.example.nhom_10_chuong_trinh_android.main.activity.CaloriesActivity;
import com.example.nhom_10_chuong_trinh_android.main.activity.QualitySleepActivity;
import com.example.nhom_10_chuong_trinh_android.main.dao.ProfileDAO;
import com.example.nhom_10_chuong_trinh_android.main.dao.QualitySleepDAO;
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
public class QualitySleepUnitTest {

    @Mock
    ProfileDAO profileDAO;

    private QualitySleepActivity qualitySleepActivity;

    @Before
    public void setup() {
        // Khởi tạo mock object
        MockitoAnnotations.initMocks(this);

        // Khởi tạo QualitySleepActivity và inject mock ProfileDAO
        qualitySleepActivity = new QualitySleepActivity();
        qualitySleepActivity.profileDAO = profileDAO;
    }

    @Test
    public void testGetStatusFromAgeGroup_Children_EnoughSleep() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Children");

        String result = qualitySleepActivity.getStatusFromAgeGroup(11.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Enough", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Youth_Sleepless() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Youth");

        String result = qualitySleepActivity.getStatusFromAgeGroup(8.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Sleepless", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Teenager_SleepTooMuch() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Teenager");

        String result = qualitySleepActivity.getStatusFromAgeGroup(11.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Sleep too much", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Adolescent_EnoughSleep() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Adolescent");

        String result = qualitySleepActivity.getStatusFromAgeGroup(8.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Enough", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Seniors_Sleepless() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Old");

        String result = qualitySleepActivity.getStatusFromAgeGroup(6.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Sleepless", result);
    }

}
