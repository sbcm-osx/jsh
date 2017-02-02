package moe.tristan.jsh.lang;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class contains List-related collection
 * convenience methods.
 */
public final class ListUtils {
    @SafeVarargs
    public static <E> List<E> listOf(final List<E>... lists) {
        return Stream.of(lists)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
