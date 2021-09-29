package io.github.mahendrabagul.cacherefresher.controllers;

import io.github.mahendrabagul.cacherefresher.kubeclient.KubeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pods")
public class PodsController {

  @Autowired
  private KubeClient kubeClient;

  //  @GetMapping
//  public String getPods() {
//    String labels = "app=nginx";
//    V1PodList podsByLabels;
//    StringBuilder stringBuilder = new StringBuilder();
//    try {
//      podsByLabels = this.kubeClient.getPodsByLabels(labels);
//      for (V1Pod item : podsByLabels.getItems()) {
//        stringBuilder.append("[");
//        stringBuilder.append(Objects.requireNonNull(item.getMetadata()).getName());
//        stringBuilder.append(" | ");
//        stringBuilder.append(Objects.requireNonNull(item.getStatus()).getPodIP());
//        stringBuilder.append("]");
//        stringBuilder.append(",");
//      }
//    } catch (IOException | ApiException exception) {
//      exception.printStackTrace();
//    }
//    if (stringBuilder.length() >= 2) {
//      return stringBuilder.substring(0, stringBuilder.length() - 2);
//    }
//    return stringBuilder.toString();
//  }
  @GetMapping
  public String getRequest() {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException interruptedException) {
      System.out.println(interruptedException);
    }
    return "Mahendra";
  }

  @PostMapping
  public ResponseEntity<String> postRequest(@RequestBody String message) {
    System.out.println("Request received : " + message);
    if (message.contains("hello")) {
      return new ResponseEntity<>(message, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
