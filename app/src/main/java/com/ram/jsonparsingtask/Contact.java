package com.ram.jsonparsingtask;


import android.provider.ContactsContract;

/**
 * Created by ram on 7/29/2017.
 */

    public class Contact {


    private String id;
    private String name;
    private String  email;
    private String address;
    private String gender;

    public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }



    }


