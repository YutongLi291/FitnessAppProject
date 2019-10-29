package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PresetPlans {

    HashMap<String, CustomPlan> plansFolder = new HashMap<String, CustomPlan>();
    String folderName;

    public PresetPlans(String folderName) {
        this.folderName = folderName;
    }


    public void addPlan(CustomPlan customPlan) {
        if (customPlan.hasAssignedFolder()) {
            customPlan.removeFromFolder();
        }
        plansFolder.put(customPlan.getPlanName(), customPlan);
        customPlan.setAssignedPlansFolder(this);
    }


    public boolean isInThisFolder(CustomPlan customPlan) {
        return (customPlan.hasAssignedFolder() && customPlan.getAssignedPlansFolder().equals(this));
    }

    public Set<String> getFolderKeys() {
        return plansFolder.keySet();
    }

    public CustomPlan getPlanFromKey(String name) {
        return plansFolder.get(name);
    }

    public void removePlan(CustomPlan plan) {
        plansFolder.remove(plan);
        plan.removeFromFolder();
    }

    public String getFolderName() {
        return folderName;
    }
}
