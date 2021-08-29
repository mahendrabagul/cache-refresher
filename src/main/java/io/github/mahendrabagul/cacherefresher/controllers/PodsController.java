package io.github.mahendrabagul.cacherefresher.controllers;

import io.github.mahendrabagul.cacherefresher.kubeclient.KubeClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import java.io.IOException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pods")
public class PodsController {

  @Autowired
  private KubeClient kubeClient;

  @GetMapping
  public String getPods() {
    String labels = "app=nginx";
    V1PodList podsByLabels;
    StringBuilder stringBuilder = new StringBuilder();
    try {
      podsByLabels = this.kubeClient.getPodsByLabels(labels);
      for (V1Pod item : podsByLabels.getItems()) {
        stringBuilder.append("[");
        stringBuilder.append(Objects.requireNonNull(item.getMetadata()).getName());
        stringBuilder.append(" | ");
        stringBuilder.append(Objects.requireNonNull(item.getStatus()).getPodIP());
        stringBuilder.append("]");
        stringBuilder.append(",");
      }
    } catch (IOException | ApiException exception) {
      exception.printStackTrace();
    }
    return stringBuilder.substring(0, stringBuilder.length() - 2);
  }
}
