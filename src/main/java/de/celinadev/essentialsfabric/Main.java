package de.celinadev.essentialsfabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Main implements ClientModInitializer {

    private static Main instance;

    public static Main getInstance() {
        if (instance == null) instance = new Main();
        return instance;
    }

    public void preInit() {
    }

    @Override
    public void onInitializeClient() {
    }
}