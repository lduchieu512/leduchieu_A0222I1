package service;

import model.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneService {
    private List<Phone> phones = new ArrayList<>();

    public void create(Phone phone) {
        int lastId = 0;

        if(phones.size() > 0){
            lastId = phones.get(phones.size() - 1).getId();
        }

        phone.setId(lastId + 1);
        phones.add(phone);
    }

    public List<Phone> findAll(){
        return phones;
    }

    public void delete(int id){
        for (int i = 0; i < phones.size(); i++) {
            if(phones.get(i).getId() ==  id){
                phones.remove(i);
                break;
            }
        }
    }

    public List<Phone> search(String name){
        List<Phone> result = new ArrayList<Phone>();

        for (int i = 0; i < phones.size(); i++) {
            if(phones.get(i).getName().contains(name)){
                result.add(phones.get(i));
            }
        }

        return result;
    }
}
