package com.backend.developer_productivity_dashboard.config;

import java.lang.System;
import com.github.alexdlaird.ngrok.NgrokClient;
import com.github.alexdlaird.ngrok.protocol.CreateTunnel;
import com.github.alexdlaird.ngrok.protocol.Tunnel;
import com.ngrok.Session;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;


@Configuration
public class NgrokConfig {
    final NgrokClient ngrokClient = new NgrokClient.Builder().build();
    final CreateTunnel createTunnel = new CreateTunnel.Builder()
            .withAddr(8080)
            .withDomain("krill-summary-implicitly.ngrok-free.app")
            .build();
    // Open an HTTP tunnel on port 8080
    // <Tunnel: "http://<public_sub>.ngrok.io" -> "http://localhost:8080">
    final Tunnel httpTunnel = ngrokClient.connect(createTunnel);

    @PostConstruct
    public void printUrl() {
        String tunnel = httpTunnel.getPublicUrl();
        System.out.println("ngrok url at: " + tunnel);
    }
}
