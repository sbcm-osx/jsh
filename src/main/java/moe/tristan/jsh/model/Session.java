package moe.tristan.jsh.model;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.Contract;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is a singleton aimed at offering
 * basic SESSION functionnality (such as
 * current directory, user and so on).
 */
@Builder
@Data
public final class Session {
    private static final Session SESSION = defaultSession();

    private Path currentDirectory;

    @Contract(pure = true)
    public static Session getSession() {
        return SESSION;
    }

    private static Session defaultSession() {
        return Session.builder()
                .currentDirectory(Paths.get(System.getProperty("user.home")))
                .build();
    }
}
