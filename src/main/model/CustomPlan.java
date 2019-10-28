package model;

import java.util.HashMap;
import java.util.HashSet;

public class CustomPlan {
    double calories;
    double dailyWorkoutMinutes;
    PresetPlans assignedPlansFolder;


    public CustomPlan(double calories, double dailyWorkoutMinutes) {
        this.calories = calories;
        this.dailyWorkoutMinutes = dailyWorkoutMinutes;
    }


    public double getCalories() {
        return calories;
    }

    public double getDailyWorkoutMinutes() {
        return dailyWorkoutMinutes;
    }

    public PresetPlans getAssignedPlansFolder() {
        return assignedPlansFolder;
    }

    public void setAssignedPlansFolder(PresetPlans presetPlans) {
        assignedPlansFolder = presetPlans;
    }


    public void addToPresetFolder(String name, PresetPlans presetPlans) {
        if (!assignedPlansFolder.equals(presetPlans)) {
            setAssignedPlansFolder(presetPlans);
            presetPlans.plansFolder.put(name, this);
        }


    }

    public void removeFromFolder() {
        if (!(assignedPlansFolder == null)) {
            assignedPlansFolder.plansFolder.remove(this);
            assignedPlansFolder = null;

        }
    }

}
