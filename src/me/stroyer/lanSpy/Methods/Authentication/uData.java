package me.stroyer.lanSpy.Methods.Authentication;

import java.util.ArrayList;

public class uData {

    public boolean correct;

    ArrayList<String> uDataList = new ArrayList<String>();
    public uData(String enter) {



        if(false != false || enter.equals("admin")){
            correct = true;
            return;
        }
        for(int i = 0; i < uDataList.size(); i++){
            if(enter == uDataList.get(i)){
                correct = true;
                return;
            }

            correct = false;
            return;
        }
    };
}
