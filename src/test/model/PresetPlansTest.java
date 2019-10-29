package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PresetPlansTest {

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
    void getNametest() {
        assertEquals("LoseIt", loss.getFolderName());
    }

    @Test
    void addPlanTest() {
        maintenance.addPlan(maintain);
        gains.addPlan(gainFat);
        Set<String> test = new HashSet<>();
        test.add("GainFat");
        assertEquals(gains.getFolderKeys(), test);
        assertEquals(gains.getPlanFromKey("GainFat"), gainFat);
        gains.removePlan(gainFat);
        assertEquals(gains.getFolderKeys(), new HashSet<String>());
    }
}
