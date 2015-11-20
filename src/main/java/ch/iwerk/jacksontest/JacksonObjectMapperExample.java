package ch.iwerk.jacksontest;

/**
 * Created by swissbib on 10/13/15.
 */

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.net.URL;
import java.util.*;


public class JacksonObjectMapperExample {

    public static void main(String[] args) throws IOException {

        //read json file data to String


        //byte[] jsonData = Files.readAllBytes(Paths.get("employee.txt"));


        //URL url = JacksonObjectMapperExample.class.getClass().
        //        getClassLoader().getResource("resources/employee.txt");
        URL url = Thread.currentThread().getContextClassLoader().getResource("employee.txt");
        InputStream stream =  url.openStream();
        long size = url.getFile().length();

        byte[] jsonData = convertSteamToByteArray(stream, size);


        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        Employee emp = objectMapper.readValue(jsonData, Employee.class);

        System.out.println("Employee Object\n"+emp);

        //convert Object to json string
        Employee emp1 = createEmployee();
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //writing to console, can write to any output stream such as file
        StringWriter stringEmp = new StringWriter();
        objectMapper.writeValue(stringEmp, emp1);
        System.out.println("Employee JSON is\n"+stringEmp);

        convertJsonToMap();

        readSpecificKey();

        editJsonDocument();


    }

    public static Employee createEmployee() {

        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("David");
        emp.setPermanent(false);
        emp.setPhoneNumbers(new long[] { 123456, 987654 });
        emp.setRole("Manager");

        Address add = new Address();
        add.setCity("Bangalore");
        add.setStreet("BTM 1st Stage");
        add.setZipcode(560100);
        emp.setAddress(add);

        List<String> cities = new ArrayList<String>();
        cities.add("Los Angeles");
        cities.add("New York");
        emp.setCities(cities);

        Map<String, String> props = new HashMap<String, String>();
        props.put("salary", "1000 Rs");
        props.put("age", "28 years");
        emp.setProperties(props);

        return emp;
    }

    private static byte[] convertSteamToByteArray(InputStream stream, long size) throws IOException {

        // check to ensure that file size is not larger than Integer.MAX_VALUE.
        if (size > Integer.MAX_VALUE) {
            return new byte[0];
        }

        byte[] buffer = new byte[(int)size];
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        int line = 0;
        // read bytes from stream, and store them in buffer
        while ((line = stream.read(buffer)) != -1) {
            // Writes bytes from byte array (buffer) into output stream.
            os.write(buffer, 0, line);
        }
        stream.close();
        os.flush();
        os.close();
        return os.toByteArray();
    }

    private static void convertJsonToMap() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("data.txt");
        try {
            InputStream stream = url.openStream();
            long size = url.getFile().length();

            byte[] mapData = convertSteamToByteArray(stream, size);

            Map<String,String> myMap = new HashMap<String, String>();

            ObjectMapper objectMapper = new ObjectMapper();
            myMap = objectMapper.readValue(mapData, HashMap.class);
            System.out.println("Map is: "+myMap);

//another way
            myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
            System.out.println("Map using TypeReference: "+myMap);
        } catch (IOException ioExc) {
            ioExc.printStackTrace();
        }
    }

    private static void readSpecificKey() {

        URL url = Thread.currentThread().getContextClassLoader().getResource("employee.txt");
        try {
            InputStream stream = url.openStream();
            long size = url.getFile().length();

            byte[] jsonData = convertSteamToByteArray(stream, size);

            ObjectMapper objectMapper = new ObjectMapper();

//read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode idNode = rootNode.path("id");
            System.out.println("id = "+idNode.asInt());

            JsonNode phoneNosNode = rootNode.path("phoneNumbers");
            Iterator<JsonNode> elements = phoneNosNode.elements();
            while(elements.hasNext()){
                JsonNode phone = elements.next();
                System.out.println("Phone No = "+phone.asLong());
            }        } catch (IOException ioExc) {
            ioExc.printStackTrace();
        }


    }


    private static void editJsonDocument() {

        URL url = Thread.currentThread().getContextClassLoader().getResource("employee.txt");
        try {
            InputStream stream = url.openStream();
            long size = url.getFile().length();

            byte[] jsonData = convertSteamToByteArray(stream, size);

            ObjectMapper objectMapper = new ObjectMapper();

//create JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonData);

//update JSON data
            ((ObjectNode) rootNode).put("id", 500);
//add new key value
            ((ObjectNode) rootNode).put("test", "test value");
//remove existing key
            ((ObjectNode) rootNode).remove("role");
            ((ObjectNode) rootNode).remove("properties");
            objectMapper.writeValue(new File("updated_emp.txt"), rootNode);
        } catch (IOException ioExc) {
            ioExc.printStackTrace();
        }


    }



}