/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.dockerclientapi;

import com.editor.dockerrunner.util.Connection;
import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.LogStream;
import com.spotify.docker.client.messages.AuthConfig;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.ContainerInfo;
import com.spotify.docker.client.messages.HostConfig;
import com.spotify.docker.client.messages.PortBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author abhisheksingh
 */
public class Test {

    public static void main(String[] args) throws DockerException, InterruptedException {

        DockerClient docker = DefaultDockerClient.builder()
                .uri("https://" + Connection.getAddress())
                .build();

        ContainerConfig containerConfig = ContainerConfig.builder()
                .image("mongo")
                //.cmd("sh","-c","'exec mongo \"$MONGO_PORT_27017_TCP_ADDR:$MONGO_PORT_27017_TCP_PORT/test\"'")
                .attachStdin(Boolean.TRUE)
                .attachStdout(Boolean.TRUE)
                .attachStderr(Boolean.TRUE)
                .build();

        ContainerCreation creation = docker.createContainer(containerConfig);
        String id = creation.id();
        
        System.out.println(id);

    }
}
