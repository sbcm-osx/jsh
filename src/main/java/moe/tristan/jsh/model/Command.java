package moe.tristan.jsh.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * This is a very basic take on what a "command" is.
 * i.e. Just a function call and its arguments.
 */
@Data
@Slf4j
public final class Command {
    final String function;
    final List<String> arguments;
}
