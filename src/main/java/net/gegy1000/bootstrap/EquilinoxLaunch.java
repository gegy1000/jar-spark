package net.gegy1000.bootstrap;

import net.gegy1000.bootstrap.loader.TransformingClassLoader;
import net.gegy1000.bootstrap.transformer.TransformerRoster;

import java.nio.file.Path;
import java.nio.file.Paths;

// TODO: write documentation

/**
 * Entry-point to the bootstrapper. This parses command line arguments into a config and sends it to the bootstrapper
 * to handle.
 */
public class EquilinoxLaunch {
    public static final TransformingClassLoader CLASS_LOADER = new TransformingClassLoader(EquilinoxLaunch.class.getClassLoader());
    public static final TransformerRoster ROSTER = new TransformerRoster();

    public static final Path LAUNCH_DIR = Paths.get("");

    public static void main(String[] args) {
        BootstrapConfig config = BootstrapConfig.parse(args);
        EquilinoxBootstrap bootstrap = new EquilinoxBootstrap(config);

        try {
            bootstrap.launch();
        } catch (Exception e) {
            // TODO: log
        }
    }
}
