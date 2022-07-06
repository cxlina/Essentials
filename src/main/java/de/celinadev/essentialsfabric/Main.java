package de.celinadev.essentialsfabric;

import de.celinadev.essentialsfabric.util.Configuration;
import de.celinadev.essentialsfabric.util.Options;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Main implements ClientModInitializer {

    private static Main instance;
    private Configuration config;
    private Options options;

    public static Main getInstance() {
        if (instance == null) instance = new Main();
        return instance;
    }

    public void preInit() {
        this.config = new Configuration();
        this.options = new Options();
        this.options.saveDefaults();
    }

    @Override
    public void onInitializeClient() {
    }

    public Configuration getConfig() {
        return config;
    }

    public Options getOptions() {
        return options;
    }
}