package ui.framework.util;

import ui.framework.config.Config;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    public static File getDataFile() {
        Path path = Paths.get(Config.getProperties("data.file.location"), Config.getProperties("data.file.name"));
        return path.toFile();
    }
}
