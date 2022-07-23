package services;

import models.Genuine;

import java.util.ArrayList;
import java.util.List;

public class AddGenuine {
    public  static List<Genuine> genuineList = new ArrayList<>();
    public static void add(Genuine genuine){
        genuineList.add(genuine);
    }


}
