package ttl.client;

import ttl.client.layout.MainLayout;
import net.zschech.gwt.websockets.client.CloseHandler;
import net.zschech.gwt.websockets.client.ErrorHandler;
import net.zschech.gwt.websockets.client.MessageEvent;
import net.zschech.gwt.websockets.client.MessageHandler;
import net.zschech.gwt.websockets.client.OpenHandler;
import net.zschech.gwt.websockets.client.WebSocket;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptException;
import com.smartgwt.client.util.Page;


public class TeachToLearn implements EntryPoint 
{
        private String WEBSOCKET_ADDRESS = "ws://namrack.kd.io:9999/echo";
        private WebSocket webSocket;
        private MainLayout mainLayout;
        
        @Override
        public void onModuleLoad() 
        {
        	// Connect to the WebSocket server:
        	connect();
        	
        	// Allow references to images be relative:
        	Page.setAppImgDir("[APP]/Resources/Images/");
        	
        	// Draw the canvas:
        	mainLayout = new MainLayout();
        	mainLayout.draw();
        }
        
        public void connect() {
                try {
                        webSocket = WebSocket.create(WEBSOCKET_ADDRESS);
                        webSocket.setOnOpen(new OpenHandler() {
                                @Override
                                public void onOpen(WebSocket webSocket) {
                                       //ToDo: onOpen
                                }
                        });
                        webSocket.setOnClose(new CloseHandler() {
                                @Override
                                public void onClose(WebSocket webSocket) {
                                        //ToDo: onClose
                                }
                        });
                        webSocket.setOnError(new ErrorHandler() {
                                @Override
                                public void onError(WebSocket webSocket) {
                                        //ToDo: onError
                                }
                        });
                        webSocket.setOnMessage(new MessageHandler() {
                                @Override
                                public void onMessage(WebSocket webSocket, MessageEvent event) {
                                        System.out.println("message: " + event.getData());
                                }
                        });
                }
                catch (JavaScriptException e) {
                        System.out.println(e.toString());
                }
        }

}