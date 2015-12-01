/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app.dockerclientapi;

import com.editor.dockerrunner.util.Connection;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.DockerException;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Link;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

/**
 *
 * @author abhisheksingh
 */
public class Test {

    public static void main(String[] args) throws DockerException, InterruptedException {

        DockerClientConfig config = DockerClientConfig.createDefaultConfigBuilder()
                .withUri("http://" + Connection.getAddress())
                .build();
        DockerClient docker = DockerClientBuilder.getInstance(config).build();
        
        Link link=new Link("mongo-demo","mongo");
        
        CreateContainerResponse createContainer=docker.createContainerCmd("mongo")
                .withAttachStdin(true)
                .withAttachStdout(true)
                .withAttachStderr(true)
                .withCmd("sh -c 'exec mongo \"$MONGO_PORT_27017_TCP_ADDR:$MONGO_PORT_27017_TCP_PORT/test\"'")
                .withLinks(link)
                .exec();
        
        String id=createContainer.getId();


        System.out.println(id);

    }
}
