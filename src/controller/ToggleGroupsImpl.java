package controller;

import javafx.scene.control.ToggleGroup;

/**
 * @author Vold
 */
public class ToggleGroupsImpl implements ToggleGroups {
    private ToggleGroup toggleGroup = null;

    /**
     * To get what the user chose
     * @param toggleGroup
     */
    public ToggleGroupsImpl(ToggleGroup toggleGroup){
        this.toggleGroup = toggleGroup;
    }
    /**
     * To see what the user chose, and split it to get the string
     * @see controller.ToggleGroups#getSelected()
     */
    @Override
    public String getSelected() {
        return (toggleGroup.getSelectedToggle().toString().split("'")[1]);
    }
}