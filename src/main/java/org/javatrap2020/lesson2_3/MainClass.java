package org.javatrap2020.lesson2_3;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext("org.javatrap2020.lesson2_3.config");

      /*  var client  = context.getBean(HttpClient.class);
        var response = client.send(context.getBean(HttpRequest.class),
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

        //HttpClient client = HttpClient.newBuilder().build();*/

      var client = context.getBean(HttpClient.class);
      var response1 =
              client.send(context.getBean(HttpRequest.class),
                      HttpResponse.BodyHandlers.ofString());

      var response2 =
              client.send((HttpRequest) context.getBean("requestEur"),
                      HttpResponse.BodyHandlers.ofString());

      var response3 =
              client.send((HttpRequest) context.getBean("requestUsd"),
                      HttpResponse.BodyHandlers.ofString());

      System.out.println(response1.body());
      System.out.println(response2.body());
      System.out.println(response3.body());
    }
}
