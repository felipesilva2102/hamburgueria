/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hamburgueria.couxchiken.config;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/keepalive")
public class KeepAliveResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response keepAlive() {
        return Response.ok("OK").build();
    }
}

