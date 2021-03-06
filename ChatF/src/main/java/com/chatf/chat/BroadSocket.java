package com.chatf.chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.chatf.user.UserServlet;
import com.chatf.user.UserVO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@ServerEndpoint("/broadcasting")
public class BroadSocket {

	
   private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
   UserServlet us = new UserServlet();
   
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println(message); //메세지 콘솔창에       
        synchronized(clients) {
            for(Session client : clients) {
                if(!client.equals(session)) {
                    client.getBasicRemote().sendText(message);
          
                    
                    
                    
                }
            }
        }
        
        
    }
    
    
    @OnOpen
    public void onOpen(Session session) {
    	
    	System.out.println(session);
        clients.add(session);
    }
    
    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
    }
}