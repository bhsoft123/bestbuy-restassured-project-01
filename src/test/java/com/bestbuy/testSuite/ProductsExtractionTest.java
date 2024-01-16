package com.bestbuy.testSuite;

//Write the following test inside ProductsExtractionTest class.
//Extraction Example
//21. Extract the limit
//22. Extract the total
//23. Extract the name of 5th product
//24. Extract the names of all the products
//25. Extract the productId of all the products
//26. Print the size of the data list
//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
//Pack)
//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
//Pack)
//29. Get all the categories of 8th products
//30. Get categories of the store where product id = 150115
//31. Get all the descriptions of all the products
//32. Get id of all the all categories of all the products
//33. Find the product names Where type = HardGood
//34. Find the Total number of categories for the product where product name = Duracell - AA
//1.5V CopperTop Batteries (4-Pack)
//35. Find the createdAt for all products whose price < 5.49
//36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-
//Pack)”
//37. Find the manufacturer of all the products
//38. Find the imge of products whose manufacturer is = Energizer
//39. Find the createdAt for all categories products whose price > 5.99
//40. Find the uri of all the products

import com.bestbuy.testBase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void response() {
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
        response.log().all();
}
//21. Extract the limit
@Test
public void test021() {
    int limit = response.extract().path("limit");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value of limit is : " + limit);
    System.out.println("------------------End of Test---------------------------");
    }
//22. Extract the total
@Test
public void test022(){
    int total = response.extract().path("total");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + total);
    System.out.println("------------------End of Test---------------------------");
    }
//23. Extract the name of 5th product
@Test
public void test023(){
    String name = response.extract().path("data[4].name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + name);
    System.out.println("------------------End of Test---------------------------");
}
//24. Extract the names of all the products
@Test
public void test024(){
    List<String> nameOfAllProducts = response.extract().path("data.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " +nameOfAllProducts );
    System.out.println("------------------End of Test---------------------------");
}

//25. Extract the productId of all the products
@Test
public void test025(){
    List<Integer> productIdAll = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " +productIdAll);
        System.out.println("------------------End of Test---------------------------");
}
//26. Print the size of the data list
@Test
public void test026(){
        List<String> dataList = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }
//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
//Pack)
@Test
public void test027(){
        List<HashMap<String,?>> valueOfproduct  = response.extract().path("data.findAll{it.name =='Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + valueOfproduct);
        System.out.println("------------------End of Test---------------------------");
    }
//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
//Pack)
@Test
public void test028(){
        String model = response.extract().path("data.find{it.name =='Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + model);
        System.out.println("------------------End of Test---------------------------");
    }
//29. Get all the categories of 8th products
@Test
public void test029(){
        List<HashMap<String,?>> categories = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        for( Object e : categories)
        System.out.println("The value is : " + e.toString());
        System.out.println("------------------End of Test---------------------------");
    }
//30. Get categories of the store where product id = 150115
@Test
public void test030(){
        List<HashMap<String,?>> categories = response.extract().path("data.findAll{it.id == 150115}.categories");
        System.out.println("------------------StartingTest---------------------------");
        for( Object e : categories)
        System.out.println("The value is : " + e.toString());
        System.out.println("------------------End of Test---------------------------");
    }
//31. Get all the descriptions of all the products
@Test
public void test031(){
        List<HashMap<String,?>> description = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        for( Object e : description)
        System.out.println("The value is : " + e.toString());
        System.out.println("------------------End of Test---------------------------");
    }
//32. Get id of all the all categories of all the products
@Test
public void test032(){
        List<HashMap<String,?>> categoriesId = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        for( Object e : categoriesId)
            System.out.println("The value is : " + e.toString());
        System.out.println("------------------End of Test---------------------------");
    }
//33. Find the product names Where type = HardGood
@Test
public void test033(){
    List<HashMap<String,?>> productNames = response.extract().path("data.findAll{it.type =='HardGood'}.name");
    System.out.println("------------------StartingTest---------------------------");
    for( Object e : productNames)
        System.out.println("The value is : " + e.toString());
    System.out.println("------------------End of Test---------------------------");
}
//34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
@Test
public void test034(){
    List<HashMap<String,?>> sizeCategories = response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + sizeCategories.size());
    System.out.println("------------------End of Test---------------------------");
}
//35. Find the createdAt for all products whose price < 5.49
@Test
public void test035(){
    List<HashMap<String,?>> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}
//36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-
//Pack)”
@Test
public void test036(){
    List<HashMap<String,?>> nameAllCategories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + nameAllCategories);
    System.out.println("------------------End of Test---------------------------");
}
//37. Find the manufacturer of all the products
@Test
public void test037(){
    List<String> manufacturer = response.extract().path("data.manufacturer");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + manufacturer);
    System.out.println("------------------End of Test---------------------------");
}
//38. Find the imge of products whose manufacturer is = Energizer
@Test
public void test038(){
    List<HashMap<String,?>> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + image);
    System.out.println("------------------End of Test---------------------------");
}
//39. Find the createdAt for all categories products whose price > 5.99
@Test
public void test039(){
    List<HashMap<String,?>> createdAt = response.extract().path("data.findAll{it.price > 5.49}.createdAt");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + createdAt);
    System.out.println("------------------End of Test---------------------------");
}
//40. Find the url of all the products
@Test
public void test040(){
    List<String> url = response.extract().path("data.url");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + url);
    System.out.println("------------------End of Test---------------------------");
}


}
