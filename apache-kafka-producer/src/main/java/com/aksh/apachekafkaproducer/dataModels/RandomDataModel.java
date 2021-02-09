package com.aksh.apachekafkaproducer.dataModels;

public class RandomDataModel {

    // Datamodel to be sent as a message to kafka topics

    String randomString;
    int randomInt;


    public RandomDataModel(){}

    public RandomDataModel(String randoString, int randomInt){
        this.randomInt = randomInt;
        this.randomString = randoString;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }
    
    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }
}
