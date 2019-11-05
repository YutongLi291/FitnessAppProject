package model;

import java.util.HashMap;
import java.util.HashSet;

public class CustomPlan {
    double calories;
    double dailyWorkoutMinutes;
    String planName;
    PresetPlans assignedPlansFolder = null;


    public CustomPlan(String planName, double calories, double dailyWorkoutMinutes) {
        this.calories = calories;
        this.dailyWorkoutMinutes = dailyWorkoutMinutes;
        this.planName = planName;
    }


    public String getPlanName() {
        return planName;
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


    public void addToPresetFolder(PresetPlans presetPlans) {
        if (hasAssignedFolder()) {
            removeFromFolder();
        }
        setAssignedPlansFolder(presetPlans);
        presetPlans.plansFolder.put(this.planName, this);
    }


    public boolean isInPresetPlan(PresetPlans presetPlans) {
        return assignedPlansFolder.equals(presetPlans);
    }

    public void removeFromFolder() {
        if (hasAssignedFolder()) {
            assignedPlansFolder.plansFolder.remove(this.planName);
            assignedPlansFolder = null;

        }
    }

    public boolean hasAssignedFolder() {
        return !(getAssignedPlansFolder() == null);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        CustomPlan that = (CustomPlan) o;
//
//        if (Double.compare(that.calories, calories) != 0) {
//            return false;
//        }
//        if (Double.compare(that.dailyWorkoutMinutes, dailyWorkoutMinutes) != 0) {
//            return false;
//        }
//        return planName.equals(that.planName);
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        temp = Double.doubleToLongBits(calories);
//        result = (int) (temp ^ (temp >>> 32));
//        temp = Double.doubleToLongBits(dailyWorkoutMinutes);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + planName.hashCode();
//        return result;
//    }
}
