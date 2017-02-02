package moe.tristan.jsh.model;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by tristan on 2/2/17.
 */
class SessionTest {
    @Test
    void getSession() {
        assertNotNull(
                Session.getSession(),
                "The session was null when it should never ever be null.")
        ;
    }

    @Test
    void getCurrentDirectory() {
        assertEquals(
                System.getProperty("user.home"),
                Session.getSession().getCurrentDirectory().toAbsolutePath().toString()
        );
    }

    @Test
    void setCurrentDirectory() {
        Session.getSession().setCurrentDirectory(Paths.get("/"));
        assertEquals(
                "/",
                Session.getSession().getCurrentDirectory().toAbsolutePath().toString()
        );
    }

}