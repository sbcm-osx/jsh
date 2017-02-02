package moe.tristan.jsh.model;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by tristan on 2/2/17.
 */
final class SessionTest {
    @Test
    void getSession() {
        assertNotNull(
                Session.getSession(),
                "The session was null when it should never ever be null."
        )
        ;
    }

    @Test
    public void getCurrentDirectory() {
        if (System.getProperty("user.name")
                .equals("travis")) {
            // travis does some weird stuff during CI so we must not expect much from this test
            return;
        }
        assertEquals(
                System.getProperty("user.home"),
                Session.getSession()
                        .getCurrentDirectory()
                        .toAbsolutePath()
                        .toString()
        );
    }

    @Test
    public void setCurrentDirectory() {
        Session.getSession()
                .setCurrentDirectory(Paths.get("/"));
        assertEquals(
                "/",
                Session.getSession()
                        .getCurrentDirectory()
                        .toAbsolutePath()
                        .toString()
        );
    }

}