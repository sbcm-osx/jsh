package moe.tristan.jsh.system.unix;

import lombok.extern.slf4j.Slf4j;
import moe.tristan.jsh.lang.ListUtils;
import moe.tristan.jsh.model.Command;
import moe.tristan.jsh.model.Session;
import moe.tristan.jsh.system.AbstractSystemExecutor;
import moe.tristan.jsh.system.SystemExecutor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Optional;

/**
 * This is a proposition of implementation of the {@link SystemExecutor}
 * for unix platforms. Because this is the default there are not many
 * workarounds associated.
 */
@Slf4j
public class UnixSystemExecutor extends AbstractSystemExecutor {

    @Override
    public Optional<OutputStream> execute(final Command command) {
        final ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command(
                ListUtils.listOf(
                        Collections.singletonList(command.getFunction()),
                        command.getArguments()
                )
        );

        processBuilder.directory(
                Session.getSession()
                        .getCurrentDirectory()
                        .toAbsolutePath()
                        .toFile()
        );

        processBuilder.inheritIO();

        try {
            final Process process = processBuilder.start();
            return Optional.ofNullable(process.getOutputStream());
        } catch (final IOException e) {
            log.error("The command you entered was invalid : " + e.getMessage());
        }

        return Optional.empty();
    }
}
