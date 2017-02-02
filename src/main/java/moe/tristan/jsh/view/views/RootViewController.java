package moe.tristan.jsh.view.views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class defines the root view.
 * It embeds the content view and possibly other
 * functionnalities to come that would be
 * wrapped as views.
 */
public class RootViewController {
    private final Map<Node, Set<EventHandler<? super Event>>> eventHandlers = new HashMap<>();
    @FXML
    private AnchorPane rootPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Pane contentPane;

    public RootViewController() {
        /*
         * Don't do anything here.
         * Instead use #initialize() to
         * do operations so you're sure every ui
         * component is loaded and ready when
         * you access them.
         */
    }

    public void initialize() {
        this.initEventhandlers();
    }

    /**
     * Stream through registered nodes, and for each node,
     * register all the even handlers mapped to it in
     * {@link #eventHandlers}.
     */
    private void initEventhandlers() {
        this.eventHandlers.keySet()
                .forEach(
                        node -> this.eventHandlers
                                .getOrDefault(node, Collections.emptySet())
                                .forEach(handler -> node.addEventHandler(EventType.ROOT, handler))
                );
    }
}
