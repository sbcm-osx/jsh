package moe.tristan.jsh.system;

import lombok.extern.slf4j.Slf4j;
import moe.tristan.jsh.model.Command;

import java.io.OutputStream;
import java.util.Optional;

/**
 * This is the base implementation of the {@link SystemExecutor} class.
 * It is to store basic input-output flow mechanics, while system-specific
 * ones must be in their own classes extending this one.
 */
@Slf4j
public abstract class AbstractSystemExecutor implements SystemExecutor {
    /**
     * This method must be overriden. Due to limitations in the intertwining of
     * Java's abstract classes and interfaces, we must have this method defined.
     * So it throws an {@link UnsupportedOperationException} when called and not
     * overriden in a subclass.
     *
     * @param command
     *         The command to execute through the current {@link SystemExecutor}.
     * @return The outputstream to which we should subscribe for shell-like output.
     */
    @Override
    public Optional<OutputStream> execute(final Command command) {
        throw new UnsupportedOperationException(
                "You must override the execute(Command) method of the SystemExecutor interface.\n" +
                        "Triggered by call to command : " + command
        );
    }
}
