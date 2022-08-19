package hackerrank;


import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;
        import java.net.*;
        //#TODO
//        import com.google.gson.Gson;
//        import com.google.gson.*;
//        import com.google.gson.reflect.*;


class ArcesiumAPI {


    /*
     * Complete the 'apiResponseParser' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY inputList
     *  2. INTEGER size
     */

    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        // String strJSon = "";
//        Gson gson = new Gson(); #TODO
        // Contacts[] contacts = null;
        List<Contacts> contacts = null;
        List<Integer> result = new ArrayList<>();
        try{
            //Create the URL object
            URL url = new URL ("https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users");
            //Retrieve the http connection
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            //Set GET method as we are trying to get details
            httpConnection.setRequestMethod("GET");
            //Connect to the endpoint
            httpConnection.connect();
            //Create an input stream reader
            InputStreamReader reader = new InputStreamReader(httpConnection.getInputStream());
            //use gson to read the jsion using input stream reader.
//            contacts = gson.fromJson(reader, new TypeToken<List<Contacts>>(){}.getType());  #TODO
            // contacts = gson.fromJson(reader, new ArrayList<Contacts>().getClass());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //Process the inputlist.
        String condition = inputList.get(1);
        if(condition.equals("EQUALS")){
            //Handling Equals condition
            //Get all the contacts and match for the value.
            for(Contacts contact : contacts){
                if(inputList.get(0).equals("id")){
                    if(contact.getId() == Long.getLong(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("name")){
                    if(contact.getName().equals(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("username")){
                    if(contact.getUsername().equals(inputList.get(2))){
                        System.out.println("username : " + contact.getUsername());
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("email")){
                    if(contact.getEmail().equals(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.street")){
                    if(contact.getAddress().getStreet().equals(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.suite")){
                    if(contact.getAddress().getSuite().equals(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.city")){
                    if(contact.getAddress().getCity().equals(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.zipcode")){
                    if(contact.getAddress().getZipcode().equals(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.geo.lat")){
                    if(contact.getAddress().getGeo().getLat() == Double.valueOf(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.geo.lng")){
                    if(contact.getAddress().getGeo().getLng() == Double.valueOf(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("website")){
                    if(contact.getWebsite().equals(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("company.name")){
                    if(contact.getCompany().getName().equals(inputList.get(2))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("company.basename")){
                    if(contact.getCompany().getBasename() == inputList.get(2)){
                        result.add(contact.getId());
                    }
                }
            }

        }else{
            //Handling IN condition
            //create a list of the input values
            List<String> inputs = Arrays.asList(inputList.get(2).split(","));
            for(Contacts contact : contacts){
                if(inputList.get(0).equals("id")){
                    if(inputs.contains(String.valueOf(contact.getId()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("name")){
                    if(inputs.contains(String.valueOf(contact.getName()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("username")){
                    if(inputs.contains(String.valueOf(contact.getUsername()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("email")){
                    if(inputs.contains(String.valueOf(contact.getEmail()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.street")){
                    if(inputs.contains(String.valueOf(contact.getAddress().getStreet()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.suite")){
                    if(inputs.contains(String.valueOf(contact.getAddress().getSuite()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.city")){
                    if(inputs.contains(String.valueOf(contact.getAddress().getCity()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.zipcode")){
                    if(inputs.contains(String.valueOf(contact.getAddress().getZipcode()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.geo.lat")){
                    if(inputs.contains(String.valueOf(contact.getAddress().getGeo().getLat()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("address.geo.lng")){
                    if(inputs.contains(String.valueOf(contact.getAddress().getGeo().getLng()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("website")){
                    if(inputs.contains(String.valueOf(contact.getWebsite()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("company.name")){
                    if(inputs.contains(String.valueOf(contact.getCompany().getName()))){
                        result.add(contact.getId());
                    }
                }
                if(inputList.get(0).equals("company.basename")){
                    if(inputs.contains(String.valueOf(contact.getCompany().getBasename()))){
                        result.add(contact.getId());
                    }
                }
            }

        }
        if(result.size() == 0 ){
            result.add(-1);
        }
        return result;
    }

}
class Contacts{
    int id;
    String name;
    String username;
    String email;
    Address address;
    String website;
    Company company;
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getUsername() {
        return this.username;
    }
    public String getEmail() {
        return this.email;
    }
    public String getWebsite() {
        return this.website;
    }
    public Address getAddress() {
        return this.address;
    }
    public Company getCompany() {
        return this.company;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

}
class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;
    public String getStreet() {
        return street;
    }
    public String getSuite() {
        return suite;
    }
    public String getCity() {
        return city;
    }
    public String getZipcode() {
        return zipcode;
    }
    public Geo getGeo(){
        return geo;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setSuite(String suite) {
        this.suite = suite;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
class Geo{
    double lat;
    double lng;
    public double getLat(){
        return lat;
    }
    public double getLng(){
        return lng;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
}
class Company{
    String name;
    String basename;
    public String getName(){
        return name;
    }
    public String getBasename(){
        return basename;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBasename(String basename) {
        this.basename = basename;
    }
}


public class ArcesiumAPIReader {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int inputListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> inputList = IntStream.range(0, inputListCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int size = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = ArcesiumAPI.apiResponseParser(inputList, size);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
