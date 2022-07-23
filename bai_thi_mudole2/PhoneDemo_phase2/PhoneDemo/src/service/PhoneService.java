package service;

import exception.NotFoundException;
import model.AuthenticPhone;
import model.HandPhone;
import model.Phone;
import util.FileHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneService {
    private List<Phone> phones = new ArrayList<>();
    private FileHelper fileHelper = new FileHelper();
    private static final String PATH = "src/data/phone.csv";

    public PhoneService(){
        phones = mapToPhones();
    }

    public void create(Phone phone) {
        int lastId = 0;

        if(phones.size() > 0){
            lastId = phones.get(phones.size() - 1).getId();
        }

        phone.setId(lastId + 1);
        phones.add(phone);
        fileHelper.write(PATH, phones, false);
    }

    public List<Phone> findAll(){
        return phones;
    }

    public void delete(int id) throws NotFoundException{
        for (int i = 0; i < phones.size(); i++) {
            if(phones.get(i).getId() ==  id){
                phones.remove(i);
                fileHelper.write(PATH, phones, false);
                return;
            }
        }

        throw new NotFoundException(id + " is not exists");
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

    private List<Phone> mapToPhones() {
        List<Phone> result = new ArrayList<>();

        List<String> lines = fileHelper.read(PATH);

        for (int i = 0; i < lines.size(); i++) {
           String[] tmp =  lines.get(i).split(",");
            int id = Integer.parseInt(tmp[0]);
            String name = tmp[1];
            Double price = Double.parseDouble(tmp[2]);
            String manufacturer = tmp[3];

            if(tmp[tmp.length - 1].equals("0")){
                int granteeByYear = Integer.parseInt(tmp[4]);
                String code = tmp[5];
                AuthenticPhone authentic = new AuthenticPhone(id, name, price, manufacturer, granteeByYear, code);
                result.add(authentic);
            }
            else{
                String country = tmp[4];
                String status = tmp[5];
                HandPhone handPhone = new HandPhone(id, name, price, manufacturer, country, status);
                result.add(handPhone);
            }
        }

        return result;
    }
}
