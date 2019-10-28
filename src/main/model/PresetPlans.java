package model;

import java.util.HashMap;
import java.util.HashSet;

public class PresetPlans {

    HashMap<String, CustomPlan> plansFolder = new HashMap<String, CustomPlan>();
    String folderName;

    public PresetPlans(String folderName) {
        this.folderName = folderName;
    }


    public void addPlan(String name, CustomPlan customPlan) {
        if (!customPlan.getAssignedPlansFolder().equals(this)) {
            plansFolder.put(name,customPlan);
            customPlan.setAssignedPlansFolder(this);
        }


    }

    public void removePlan(CustomPlan plan) {
        plansFolder.remove(plan);
        plan.removeFromFolder();
    }

    public String getName() {
        return folderName;
    }
}
