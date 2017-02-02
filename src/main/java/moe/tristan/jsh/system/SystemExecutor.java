package moe.tristan.jsh.system;

import moe.tristan.jsh.model.Command;

import java.io.OutputStream;
import java.util.Optional;

/**
 * This interface defines the behavior that an executor listOf system calls
 * has to provide. Look into implementing {@link AbstractSystemExecutor} for
 * details on implementation.
 */
public interface SystemExecutor {
    Optional<OutputStream> execute(Command command);
}

