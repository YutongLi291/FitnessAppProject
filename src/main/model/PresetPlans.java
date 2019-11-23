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

    //Modifies: this, CustomPlan
    //Effects: adds a customPlan to this folder
    public void addPlan(CustomPlan customPlan) {
        if (customPlan.hasAssignedFolder()) {
            customPlan.removeFromFolder();
        }
        plansFolder.put(customPlan.getPlanName(), customPlan);
        customPlan.setAssignedPlansFolder(this);
    }


    //Effects: returns true if the customPlan is in this folder
    public boolean isInThisFolder(CustomPlan customPlan) {
        return (customPlan.hasAssignedFolder() && customPlan.getAssignedPlansFolder().equals(this));
    }

    //Effects: get the keys for plansFolder
    public Set<String> getFolderKeys() {
        return plansFolder.keySet();
    }

    //Effects: gets a corresponding plan from a given key
    public CustomPlan getPlanFromKey(String name) {
        return plansFolder.get(name);
    }

    //Modifies: this, CustomPlan
    //Effects: removes specified plan from this folder
    public void removePlan(CustomPlan plan) {
        plansFolder.remove(plan);
        plan.removeFromFolder();
    }

    //Effects: returns the folderName
    public String getFolderName() {
        return folderName;
    }
}
