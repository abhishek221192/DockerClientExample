/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.editor.dockerrunner.util;

/**
 *
 * @author abhishek221192
 */
public class Connection {
    public static String getAddress()
    {
        return "52.32.132.147:2375";
    }
    
    public static String getUrl(String url)
    {
        return "http://"+getAddress()+"/"+url;
    }
}
