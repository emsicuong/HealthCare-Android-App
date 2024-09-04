package com.example.nhom_10_chuong_trinh_android;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.example.nhom_10_chuong_trinh_android.main.activity.BMIIndexActivity;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 28)
public class BmiIndexUnitTest {

    @Test
    public void testGetStatus_NoUnderlyingDiseases_Youth_NormalBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>();
        float height = 1.6f;
        float weight = 50f;
        String ageGroup = "Youth";

        String expected = "Malnutrition";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStatus_Diabetes_MiddleAge_OverweightBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Diabetes"));
        float height = 1.7f;
        float weight = 85f;
        String ageGroup = "Middle-age";

        String expected = "Normal";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStatus_HighBloodPressure_Adolescent_UnderweightBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("High blood pressure"));
        float height = 1.75f;
        float weight = 60f;
        String ageGroup = "Adolescent";

        String expected = "Normal";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStatus_Fatigue_Children_MalnutritionBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Fatigue"));
        float height = 1.0f;
        float weight = 10f;
        String ageGroup = "Children";

        String expected = "Malnutrition";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStatus_MentalIllness_Old_FatBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Mental illness"));
        float height = 1.5f;
        float weight = 100f;
        String ageGroup = "Old";

        String expected = "Fat";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

}
