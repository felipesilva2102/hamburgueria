/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hamburgueria.couxchiken.config;

import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Singleton
public class KeepAliveScheduler {

    @Schedule(hour="*", minute="*", second="*/5", persistent=false)
    public void executar() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://fecatolica.onrender.com/api/keepalive"))
                    .GET()
                    .build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
