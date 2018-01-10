package com.nicholasnassar.website;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.templ.JadeTemplateEngine;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebHandler {
    private final Vertx vertx;

    private final JadeTemplateEngine jade;

    private final String websiteName;

    private final List<Project> projects;

    private final List<Job> jobs;

    public WebHandler(RoutingExtras extras) {
        vertx = Vertx.vertx();

        jade = JadeTemplateEngine.create();

        websiteName = "Nicholas Nassar";

        projects = new ArrayList<>();

        try {
            JsonArray array = new JsonArray(IOUtils.toString(getClass().getClassLoader().getResourceAsStream("projects.json")));

            for (Object object : array) {
                JsonObject json = (JsonObject) object;

                projects.add(new Project(json.getString("title"), json.getString("description"),
                        json.getString("linkText"), json.getString("link"), json.getString("background")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        jobs = new ArrayList<>();

        try {
            JsonArray array = new JsonArray(IOUtils.toString(getClass().getClassLoader().getResourceAsStream("jobs.json")));

            for (Object object : array) {
                JsonObject json = (JsonObject) object;

                jobs.add(new Job(json.getString("name"), json.getString("link"), json.getString("time"),
                        json.getString("skills"), json.getString("experience")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Router router = Router.router(vertx);

        router.get("/").handler(ctx -> {
            ctx.put("projects", projects);

            ctx.put("jobs", jobs);

            renderWithJade(ctx, "index");
        });

        router.get("/contact").handler(ctx -> renderWithJade(ctx, "contact", "Contact"));

        if (extras != null) {
            extras.setupRoutes(this, vertx, router);
        }

        router.route().handler(StaticHandler.create("web").setMaxAgeSeconds(604800));

        HttpServerOptions options = new HttpServerOptions();

        options.setCompressionSupported(true);

        vertx.createHttpServer(options).requestHandler(router::accept).listen(3000);

        System.out.println("Website started!");

        Scanner scanner = new Scanner(System.in);

        String line;

        while ((line = scanner.nextLine()) != null) {
            if (line.equals("stop")) {
                break;
            }
        }

        stop();
    }

    public void renderWithJade(RoutingContext ctx, String template) {
        renderWithJade(ctx, template, null);
    }

    public void renderWithJade(RoutingContext ctx, String template, String page) {
        ctx.put("title", page == null ? websiteName : page + " - " + websiteName);
        ctx.put("websiteName", websiteName);

        jade.render(ctx, "templates/", template, res -> {
            if (res.succeeded()) {
                ctx.response().putHeader(HttpHeaders.CONTENT_TYPE, "text/html").end(res.result());
            } else {
                ctx.fail(res.cause());
            }
        });
    }

    private void stop() {
        System.out.println("Stopping...");

        vertx.close();
    }

    public static void main(String[] args) {
        new WebHandler(null);
    }
}
