package com.nicholasnassar.website;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public interface RoutingExtras {
    void setupRoutes(WebHandler handler, Vertx vertx, Router router);
}
