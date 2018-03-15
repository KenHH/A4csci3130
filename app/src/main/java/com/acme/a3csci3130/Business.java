package com.acme.a3csci3130;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;


/**
  * Class that defines how the data will be stored in the
  * Firebase database. This is converted to a JSON format
 **/

        public class Business implements Serializable {

            public String uid;
            public String businessNumber;
            public String name;
            public String businessPrimary;
            public String address;
            public String provinceTerritory;

            public Business() {
                    }
    /**
     * Instantiate a Business method
     * @param uid ID of this business
     * @param businessNumber A 9 digit number for the business
     * @param name The name of the business
     * @param businessPrimary The primary job
     * @param address The address of the business
     * @param provinceTerritory The province/territory of the business
     */
            public Business(String uid, String businessNumber, String name, String businessPrimary, String address, String provinceTerritory) {

                this.uid = uid;
                this.businessNumber = businessNumber;
                this.name = name;
                this.businessPrimary = businessPrimary;
                this.address = address;
                this.provinceTerritory = provinceTerritory;

            }

            @Exclude
    public Map<String, Object> toMap() {

                HashMap<String, Object> result = new HashMap<>();
                result.put("uid", uid);
                result.put("businessNumber", businessNumber);
                result.put("name", name);
                result.put("primaryBusiness", businessPrimary);
                result.put("address", address);
                result.put("provinceTerritory", provinceTerritory);

                return result;
            }
}