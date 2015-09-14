package com.clear.faun.fuzzyapp.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by spencer on 9/8/2015.
 */
public class FuzzPOJO {


    private String id;
    private String type;
    private String date;
    private String data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The type
         */
        public String getType() {
            return type;
        }

        /**
         *
         * @param type
         * The type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         *
         * @return
         * The date
         */
        public String getDate() {
            return date;
        }

        /**
         *
         * @param date
         * The date
         */
        public void setDate(String date) {
            this.date = date;
        }

        /**
         *
         * @return
         * The data
         */
        public String getData() {
            return data;
        }

        /**
         *
         * @param data
         * The data
         */
        public void setData(String data) {
            this.data = data;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

}