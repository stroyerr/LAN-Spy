package me.stroyer.lanSpy.Listeners;

public class lanListener {

    public int id;
    public String name;
    public String channel;

    String[] listenerTypes = new String[5];

    public lanListener(int id, String name, int channelInt){
        this.id = id;
        this.name = name;

        listenerTypes[4] = "IPv6"; listenerTypes[1] = "DNS"; listenerTypes[2] = "Domain"; listenerTypes[3] = "Subnet Gateway"; listenerTypes[0] = "-- Select a listener channel --";

        channel = listenerTypes[channelInt];
        listenerStorage.listeners.add(this);

    }
}
