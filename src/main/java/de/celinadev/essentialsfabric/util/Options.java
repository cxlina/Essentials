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
    public boolean fixResourceReloadExploit;
    public boolean enableGodArmorEnchantments;

    public Options() {
        this.ignoreUpdate = false;
        Configuration config = Main.getInstance().getConfig();
        this.fixOptionValues = config.isEnabled("fixOptionValues", true);
        this.fixDataFixer = config.isEnabled("fixDataFixer", true);
        this.fixSliderSound = config.isEnabled("fixSliderSound", true);
        this.fixNetherFog = config.isEnabled("fixNetherFog", true);
        this.fixCapeStuttering = config.isEnabled("fixCapeStuttering", true);
        this.fixResourceReloadExploit = config.isEnabled("fixResourceReloadExploit", true);
        this.enableGodArmorEnchantments = config.isEnabled("enableGodArmorEnchantments", false);
    }

    public void saveDefaults() {
        try {
            Configuration config = Main.getInstance().getConfig();
            config.getFile().addDefault("fixOptionValues", true);
            config.getFile().addDefault("fixDataFixer", true);
            config.getFile().addDefault("fixSliderSound", true);
            config.getFile().addDefault("fixNetherFog", true);
            config.getFile().addDefault("fixCapeStuttering", true);
            config.getFile().addDefault("fixResourceReloadExploit", true);
            config.getFile().addDefault("enableGodArmorEnchantments", false);
            config.getFile().save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
