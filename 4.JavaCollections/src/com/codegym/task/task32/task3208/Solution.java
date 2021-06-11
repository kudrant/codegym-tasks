package com.codegym.task.task32.task3208;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI (part 2)

*/
public class Solution {
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {

            //write your code here
            try {
                Animal cat = new Cat("Cat");
                Animal dog = new Dog("Dog");
                registry = LocateRegistry.createRegistry(2099);
                // Create a stub for receiving remote calls.
                Remote remoteCat = UnicastRemoteObject.exportObject(cat, 0);
                Remote remoteDog = UnicastRemoteObject.exportObject(dog, 0);
                // Register the stub in the registry.
                registry.bind("catBind", remoteCat);
                registry.bind("dogBind", remoteDog);
            }catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}