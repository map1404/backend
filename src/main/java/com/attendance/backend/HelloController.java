package com.attendance.backend;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/getstudentinfo")
    public String hello() throws IOException, ParseException{
        JSONParser parser = new JSONParser();
        String returnobj = new String();
         FileReader reader = new FileReader("C:\\Users\\Ponni\\Desktop\\Student.json");
        {
            Object obj = parser.parse(reader);

            if (obj instanceof JSONObject)
            {
                JSONObject jsonData = (JSONObject) obj;
                // Display the JSON object data in a pretty format
                System.out.println(jsonData.toString());
            }
            else if (obj instanceof JSONArray)
            {
                JSONArray jsonArray = (JSONArray) obj;
                // Display the JSON array data in a pretty format
                
                returnobj = jsonArray.toString();
            }
        }
        ObjectMapper mapper = new ObjectMapper();

	//JSON file to Java object
        Student obj = mapper.readValue(new File("C:\\Users\\Ponni\\Desktop\\Student.json"), Student.class);



        
        return returnobj;
    }

    
}
