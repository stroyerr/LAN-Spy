package me.stroyer.lanSpy.Methods.Authentication;

public class AttemptLogin {
    public static boolean login (String password){
        uData data = new uData(password);
        return data.correct;
    }
}
