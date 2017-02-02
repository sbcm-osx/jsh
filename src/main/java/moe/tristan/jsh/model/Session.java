package moe.tristan.jsh.model;

import lombok.Data;
import org.jetbrains.annotations.Contract;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is a singleton aimed at offering
 * basic SESSION functionnality (such as
 * current directory, user and so on).
 */
@Data
public final class Session {
    private static final Session SESSION = new Session();

    private Path currentDirectory;

    private Session() {
        this.currentDirectory = Paths.get(System.getProperty("home"));
    }

    @Contract(pure = true)
    public static Session getSession() {
        return SESSION;
    }
}
