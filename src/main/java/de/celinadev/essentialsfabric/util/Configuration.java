package de.celinadev.essentialsfabric.util;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

public class Configuration {

    private YamlFile file;

    public Configuration() {
        try {
            this.file = new YamlFile("./config/essentials.yml");
            if (!this.file.exists()) {
                this.file.createNewFile();
            }
            this.file.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public YamlFile getFile() {
        return file;
    }

    public boolean isEnabled(String path) {
        return this.file.getBoolean(path, true);
    }

    public void set(String path, Object value) {
        try {
            this.file.set(path, value);
            this.file.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}