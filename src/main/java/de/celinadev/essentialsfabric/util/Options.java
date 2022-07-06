package de.celinadev.essentialsfabric.util;

import de.celinadev.essentialsfabric.Main;

import java.io.IOException;

public class Options {

    public boolean ignoreUpdate;
    public boolean fixOptionValues;
    public boolean fixDataFixer;
    public boolean fixSliderSound;
    public boolean fixNetherFog;
    public boolean fixCapeStuttering;

    public Options() {
        this.ignoreUpdate = false;
        Configuration config = Main.getInstance().getConfig();
        this.fixOptionValues = config.isEnabled("fixOptionValues");
        this.fixDataFixer = config.isEnabled("fixDataFixer");
        this.fixSliderSound = config.isEnabled("fixSliderSound");
        this.fixNetherFog = config.isEnabled("fixNetherFog");
        this.fixCapeStuttering = config.isEnabled("fixCapeStuttering");
    }

    public void saveDefaults() {
        try {
            Configuration config = Main.getInstance().getConfig();
            config.getFile().addDefault("fixOptionValues", true);
            config.getFile().addDefault("fixDataFixer", true);
            config.getFile().addDefault("fixSliderSound", true);
            config.getFile().addDefault("fixNetherFog", true);
            config.getFile().addDefault("fixCapeStuttering", true);
            config.getFile().save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
