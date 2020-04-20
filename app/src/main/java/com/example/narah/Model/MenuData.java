package com.example.narah.Model;

public class MenuData {
 public void btnSave_onClick(View view) {
        Narah[] narah = new Narah[20];

        narah[0]= new Narah("Pizza","small");
        narah[1]= new Narah("Pizza","medium");
        narah[2]= new Narah("Pizza","Large");
        narah[3]= new Narah("Pizza","Stuffed Crust");
        narah[4]= new Narah("Egg Pastries","Plain Eggs");
        narah[5]= new Narah("Egg Pastries","Eggs and Cheese");
        narah[6]= new Narah("Egg Pastries","Eggs and Sausage");
        narah[7]= new Narah("Egg Pastries","Eggs and Hotdogs");
        narah[8]= new Narah("Calzone","chicken and Vegetables");
        narah[9]= new Narah("Calzone"," Spicy chicken ");
        narah[10]= new Narah("Pastries","Meshulash");
        narah[11]= new Narah("Pastries","Cheese and Olive");
        narah[12]= new Narah("Pastries","Bulgarian");
        narah[13]= new Narah("Pastries","Za`atar Manakish");
        narah[14]= new Narah("Pastries","All type of Cheese");
        narah[15]= new Narah("Pastries","Rayaneh");
        narah[16]= new Narah("Dessert","Baked Nutella");
        narah[17]= new Narah("Dessert","Baked Lotus");
        narah[18]= new Narah("Dessert","Apple Pie");
        narah[19]= new Narah("Extras","Fries");

        ///
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefs.edit();
        Gson gson = new Gson();
        String narahString = gson.toJson(narah);
        editor.putString("123",narahString);
        editor.commit();


    }
}
