package moe.tristan.jsh.system;

import moe.tristan.jsh.model.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by tristan on 2/2/17.
 */
final class AbstractSystemExecutorTest {
    @Test
    public void execute() {
        //noinspection AnonymousInnerClassMayBeStatic
        final SystemExecutor executor = new AbstractSystemExecutor() {};
        final Command command = Command.builder()
                .function("ls")
                .build();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> executor.execute(command));
    }
}