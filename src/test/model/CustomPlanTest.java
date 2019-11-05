package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CustomPlanTest {

    CustomPlan weightLoss;
    CustomPlan extremeWeightLoss;
    CustomPlan maintain;
    CustomPlan gainFat;
    CustomPlan gainMuscle;
    PresetPlans gains;
    PresetPlans loss;
    PresetPlans maintenance;
    @BeforeEach
    void setup() {
    weightLoss = new CustomPlan("WeightLoss", 1500, 60);
   extremeWeightLoss = new CustomPlan("ExtremeWeightLoss", 1000, 120);
     maintain = new CustomPlan("Maintain", 2000, 30);
     gainFat = new CustomPlan("GainFat", 2500, 0);
     gainMuscle = new CustomPlan("GainMuscle", 2500, 120);
     gains = new PresetPlans("Gains");
     loss = new PresetPlans("LoseIt");
     maintenance= new PresetPlans("Maintenance");
    }

    @Test
    void getPlanNameTest() {
        assertEquals("WeightLoss", weightLoss.getPlanName());
        assertEquals("GainFat", gainFat.getPlanName());
    }

    @Test
    void getCaloriesTest() {
        assertEquals(2000, maintain.getCalories());
    }

    @Test
    void getWorkoutMinutesTest() {
        assertEquals(120, extremeWeightLoss.getDailyWorkoutMinutes());
    }

    @Test
    void addToPresetPlanFolderTest() {
        weightLoss.addToPresetFolder(loss);
        assertEquals(loss, weightLoss.getAssignedPlansFolder());
        Set<String> test = new HashSet<>();
        test.add("WeightLoss");
        assertEquals(loss.plansFolder.keySet(),test );
        assertEquals(loss.plansFolder.get("WeightLoss"), weightLoss );
        extremeWeightLoss.addToPresetFolder(loss);
        test.add("ExtremeWeightLoss");
        assertEquals(loss.plansFolder.keySet(), test);
        assertEquals(loss.plansFolder.get("ExtremeWeightLoss"), extremeWeightLoss);
        assertTrue(extremeWeightLoss.isInPresetPlan(loss));
        assertFalse(extremeWeightLoss.isInPresetPlan(maintenance));
        assertTrue(extremeWeightLoss.hasAssignedFolder());
        extremeWeightLoss.removeFromFolder();
        assertFalse(extremeWeightLoss.hasAssignedFolder());
        weightLoss.removeFromFolder();
        assertEquals(loss.plansFolder.keySet(), new HashSet<>());
    }






    //TODO: equals and hashCode tests
    @Test
    void equalsTest() {

    }








}
