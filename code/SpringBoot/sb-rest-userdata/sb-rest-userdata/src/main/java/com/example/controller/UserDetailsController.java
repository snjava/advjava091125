package com.example.controller;
import com.example.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserDetailsController {
    //http://localhost:8080/data-by-param?name=abc&age=22
    @GetMapping("/data-by-param")
    public String userDataByParameter(@RequestParam("name") String name,
                                      @RequestParam("age") int age) {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        return "HELLO... USER DATA FROM PARAMETER.. Name : " + name;
    }

    //http://localhost:8080/xyz/data-by-path/25
    @GetMapping("/{username}/data-by-path/{userage}")
    public String userDataByPathVariable(@PathVariable(name = "username") String name,
                                         @PathVariable(name = "userage") int age) {
        System.out.println("User Name : " + name);
        System.out.println("User Age : " + age);
        return "HELLO... USER DATA FROM PATH VARIABLE.. Name : " + name;
    }
    /*
    http://localhost:8080/data-by-request-body
    {
        "name": "Test ABC",
        "age": 23
    }
     */
    @PostMapping("/data-by-request-body")
    public String UserDataByRequestBody(@RequestBody User user) {
        System.out.println("User Name : " + user.getName());
        System.out.println("User Age : " + user.getAge());
        return "HELLO... USER DATA FROM REQUEST BODY(JSON).. Name : "
                + user.getName();
    }
}
